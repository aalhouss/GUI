// main.cpp : Defines the entry point for the application.
//

#include "framework.h"
#include "main.h"

#include "resource.h"
#include <windows.h>
LRESULT CALLBACK WndProc(HWND, UINT, WPARAM, LPARAM);
BOOL  CALLBACK DialogProc(HWND, UINT, WPARAM, LPARAM);
void AddMenus(HWND);
void start_paint(HWND);
void registerDialogClass(HINSTANCE);
void displayDialog(HWND);
static bool draw = false;
static bool draw2 = false;
typedef struct _SYSTEMTIME1 
{

     WORD wHour ;
     WORD wMinute ;
     WORD wSecond ;
     
} 
SYSTEMTI ;
HMENU hMenu;
HWND button1;
HWND dialog{};
HINSTANCE g_hinst;
COLORREF g_color;
HINSTANCE ht;
/*
static BOOL   f24Hour, fSuppress ;
	 static HBRUSH hBrushRed ;
	 static int    cxClient, cyClient ;
	 HDC           hdc ;
	 PAINTSTRUCT   ps ;
	 TCHAR         szBuffer [2] ;*/
int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance,
	PSTR szCmdLine, int iCmdShow)
{
	static TCHAR szAppName[] = TEXT("DigClock");
	HWND         hwnd;
	MSG          msg;
	WNDCLASS     wndclass;

	wndclass.style = CS_HREDRAW | CS_VREDRAW;
	wndclass.lpfnWndProc = WndProc;
	wndclass.cbClsExtra = 0;
	wndclass.cbWndExtra = 0;
	wndclass.hInstance = hInstance;
	wndclass.hIcon = LoadIcon(NULL, IDI_APPLICATION);
	wndclass.hCursor = LoadCursor(NULL, IDC_ARROW);
	wndclass.hbrBackground = (HBRUSH)GetStockObject(WHITE_BRUSH);
	wndclass.lpszMenuName = NULL;
	wndclass.lpszClassName = szAppName;

	if (!RegisterClass(&wndclass))
	{

		MessageBox(NULL, TEXT("Program requires Windows NT!"),
			szAppName, MB_ICONERROR);
		return 0;
	}

	hwnd = CreateWindow(szAppName, TEXT("Digital Clock"),
		WS_OVERLAPPEDWINDOW,
		CW_USEDEFAULT, CW_USEDEFAULT,
		CW_USEDEFAULT, CW_USEDEFAULT,
		NULL, NULL, hInstance, NULL);
	//int ret = DialogBox(GetModuleHandle(NULL), MAKEINTRESOURCE(IDD_DIALOG2), hwnd, DialogProc);
	
	dialog = CreateDialog(hInstance, MAKEINTRESOURCE(IDD_DIALOG2), NULL, DialogProc);

	if (!dialog) {
		MessageBox(NULL, L"NOT CREATED", L"KK", MB_ICONERROR);
		return 1;
	}
	ShowWindow(hwnd, iCmdShow);
	UpdateWindow(hwnd);
	//ShowWindow(dialog, iCmdShow);
	//UpdateWindow(dialog);
	
	// MessageBox(NULL,L"Hello",L"Hi",MB_OK);
	while (GetMessage(&msg, NULL, 0, 0))
	{
		TranslateMessage(&msg);
		DispatchMessage(&msg);
	}
	return msg.wParam;
}

void DisplayDigit(HDC hdc, int iNumber)
{
	static BOOL  fSevenSegment[10][7] = {
						1, 1, 1, 0, 1, 1, 1,     // 0
						0, 0, 1, 0, 0, 1, 0,     // 1
						1, 0, 1, 1, 1, 0, 1,     // 2
						1, 0, 1, 1, 0, 1, 1,     // 3
						0, 1, 1, 1, 0, 1, 0,     // 4
						1, 1, 0, 1, 0, 1, 1,     // 5
						1, 1, 0, 1, 1, 1, 1,     // 6
						1, 0, 1, 0, 0, 1, 0,     // 7
						1, 1, 1, 1, 1, 1, 1,     // 8
						1, 1, 1, 1, 0, 1, 1 };  // 9
	static POINT ptSegment[7][6] = {
						 7,  6,  11,  2,  31,  2,  35,  6,  31, 10,  11, 10,
						 6,  7,  10, 11,  10, 31,   6, 35,   2, 31,   2, 11,
						36,  7,  40, 11,  40, 31,  36, 35,  32, 31,  32, 11,
						 7, 36,  11, 32,  31, 32,  35, 36,  31, 40,  11, 40,
						 6, 37,  10, 41,  10, 61,   6, 65,   2, 61,   2, 41,
						36, 37,  40, 41,  40, 61,  36, 65,  32, 61,  32, 41,
						 7, 66,  11, 62,  31, 62,  35, 66,  31, 70,  11, 70 };
	int          iSeg;

	for (iSeg = 0; iSeg < 7; iSeg++)
		if (fSevenSegment[iNumber][iSeg])
			Polygon(hdc, ptSegment[iSeg], 6);
}

void DisplayTwoDigits(HDC hdc, int iNumber, BOOL fSuppress)
{
	if (!fSuppress || (iNumber / 10 != 0))
		DisplayDigit(hdc, iNumber / 10);
	OffsetWindowOrgEx(hdc, -42, 0, NULL);
	DisplayDigit(hdc, iNumber % 10);
	OffsetWindowOrgEx(hdc, -42, 0, NULL);
}

void DisplayColon(HDC hdc)
{
	POINT ptColon[2][4] = { 2,  21,  6,  17,  10, 21,  6, 25,
							 2,  51,  6,  47,  10, 51,  6, 55 };

	Polygon(hdc, ptColon[0], 4);
	Polygon(hdc, ptColon[1], 4);

	OffsetWindowOrgEx(hdc, -12, 0, NULL);
}

void DisplayTime(HDC hdc, BOOL f24Hour, BOOL fSuppress)
{
	SYSTEMTIME st;

	GetLocalTime(&st);

	if (f24Hour)
		DisplayTwoDigits(hdc, st.wHour, fSuppress);
	else
		DisplayTwoDigits(hdc, (st.wHour %= 12) ? st.wHour : 12, fSuppress);

	DisplayColon(hdc);
	DisplayTwoDigits(hdc, st.wMinute, FALSE);
	DisplayColon(hdc);
	DisplayTwoDigits(hdc, st.wSecond, FALSE);
}

const char ClassName[] = "MainWindowClass";

HWND hWndButton1;

HWND hWndButton2;

LRESULT CALLBACK WndProc(HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam)
{

	static BOOL   f24Hour, fSuppress;
	static HBRUSH hBrushRed;
	static int    cxClient, cyClient;
	HDC           hdc;
	PAINTSTRUCT   ps;
	TCHAR         szBuffer[2];
	int val;
	bool checked = true;
	


	//HWND hDlg;
	//hDlg = CreateDialogParam(ht, MAKEINTRESOURCE(IDD_DIALOG2), 0, DialogProc, 0);

	switch (message)
	{
	case WM_CREATE:
		hBrushRed = CreateSolidBrush(RGB(255, 0, 0));
		SetTimer(hwnd, ID_TIMER, 1000, NULL);
		AddMenus(hwnd);
		// HINSTANCE hInstance = (HINSTANCE)GetWindowLong(hwnd, GWL_HINSTANCE);
		 // CreateWindowW(L"Button", L"Choose colour",
			  //   WS_CHILD | WS_VISIBLE | BS_GROUPBOX,
				// 10, 10, 120, 110, hwnd, (HMENU) 0, g_hinst, NULL);


												 // fall through
	case WM_COMMAND:
		switch (LOWORD(wParam)) {
		case IDM_MODE_WAHL:
			//CheckMenuRadioItem(hMenu, IDM_MODE_WAHL, IDM_MODE_EXIT,
				//IDM_MODE_VORG, MF_BYCOMMAND);
			MessageBeep(MB_ICONERROR);
			ShowWindow(dialog, SW_SHOW);
			//displayDialog(hwnd);

				//MessageBox(hwnd, szLE, TEXT("Error"), MB_OK);


		case IDM_MODE_AKT:
			/*CheckMenuRadioItem(hMenu, IDM_MODE_AKT, IDM_MODE_EXIT,
				IDM_MODE_AKT, MF_BYCOMMAND);
			MessageBeep(MB_ICONERROR);
			   displayDialog(hwnd);
			   draw=true;
			RedrawWindow(hwnd,0,0,RDW_INVALIDATE);
			*/

			//draw = true;
			RedrawWindow(hwnd, 0, 0, RDW_INVALIDATE);

			//CreateWindow("Akt","Uhr",WS_VISIBLE|WS_CHILD|SS_CENTER,80,50,98,38,hwnd,NULL,NULL,NULL);

			break;
		case IDM_MODE_VORG:
			//CheckMenuRadioItem(hMenu, IDM_MODE_AKT, IDM_MODE_EXIT,
				//IDM_MODE_VORG, MF_BYCOMMAND);
			MessageBeep(0xFFFFFFFF);
			break;
		case IDM_MODE_EXIT:

			val = MessageBox(hwnd, L"Are you sure?", L"Wait!", MB_YESNO | MB_ICONEXCLAMATION);
			if (val == IDYES) {
				DestroyWindow(hwnd);
			}
			break;
		}


		return 0;


	case WM_SETTINGCHANGE:
		GetLocaleInfo(LOCALE_USER_DEFAULT, LOCALE_ITIME, szBuffer, 2);
		f24Hour = (szBuffer[0] == '1');

		GetLocaleInfo(LOCALE_USER_DEFAULT, LOCALE_ITLZERO, szBuffer, 2);
		fSuppress = (szBuffer[0] == '0');

		InvalidateRect(hwnd, NULL, TRUE);
		return 0;

	case WM_SIZE:
		cxClient = LOWORD(lParam);
		cyClient = HIWORD(lParam);
		return 0;

	case WM_TIMER:
		InvalidateRect(hwnd, NULL, TRUE);
		return 0;

	case WM_PAINT:
		if (draw == true) {
			hdc = BeginPaint(hwnd, &ps);

			SetMapMode(hdc, MM_ISOTROPIC);
			SetWindowExtEx(hdc, 276, 72, NULL);
			SetViewportExtEx(hdc, cxClient, cyClient, NULL);

			SetWindowOrgEx(hdc, 138, 36, NULL);
			SetViewportOrgEx(hdc, cxClient / 2, cyClient / 2, NULL);
			SelectObject(hdc, GetStockObject(NULL_PEN));
			SelectObject(hdc, hBrushRed);

			DisplayTime(hdc, f24Hour, fSuppress);

			EndPaint(hwnd, &ps);
		}
		if (draw2 == true) {
			hdc = BeginPaint(hwnd, &ps);

			SetMapMode(hdc, MM_ISOTROPIC);
			SetWindowExtEx(hdc, 276, 72, NULL);
			SetViewportExtEx(hdc, cxClient, cyClient, NULL);

			SetWindowOrgEx(hdc, 138, 36, NULL);
			SetViewportOrgEx(hdc, cxClient / 2, cyClient / 2, NULL);
			SelectObject(hdc, GetStockObject(NULL_PEN));
			SelectObject(hdc, hBrushRed);

			//DisplayTime(hdc, f24Hour, fSuppress);

			EndPaint(hwnd, &ps);
		}
		return 0;

	case WM_CLOSE:
		MessageBeep(MB_OK);
		if (MessageBox(hwnd, L"Really quit?", L"My application", MB_OKCANCEL | MB_ICONEXCLAMATION) == IDOK)
		{
			DestroyWindow(hwnd);
		}
		// Else: User canceled. Do nothing.
		return 0;

	case WM_DESTROY:
		KillTimer(hwnd, ID_TIMER);
		DeleteObject(hBrushRed);
		PostQuitMessage(0);
		return 0;
	}
	return DefWindowProc(hwnd, message, wParam, lParam);
}
void AddMenus(HWND hwnd) {
	hMenu = CreateMenu();
	HMENU hFileMenu = CreateMenu();
	// HMENU hSubMenu=CreateMenu();

  // AppendMenu(hSubMenu,MF_STRING,NULL,"Subitems");

	AppendMenu(hFileMenu, MF_STRING, IDM_MODE_WAHL, L"UhrZeit wählen");
	//AppendMenu(hFileMenu,MF_STRING,IDM_MODE_VORG,"Vorgegeben");
	AppendMenu(hFileMenu, MF_SEPARATOR, NULL, NULL);
	AppendMenu(hFileMenu, MF_STRING, IDM_MODE_EXIT, L"Exit");

	CheckMenuRadioItem(hMenu, IDM_MODE_AKT, IDM_MODE_EXIT,
		IDM_MODE_AKT, MF_BYCOMMAND);

	AppendMenu(hMenu, MF_POPUP, (UINT_PTR)hFileMenu, L"Datei");

	SetMenu(hwnd, hMenu);
}


BOOL  CALLBACK DialogProc(HWND hDlg, UINT uMsg, WPARAM wParam, LPARAM lParam)
{
	static HWND hButtonFlash = NULL;
	static HWND hButtonReq = NULL;
	static HWND hEdit1 = NULL;
	TCHAR buff[1024];
	TCHAR buff2[1024];
	TCHAR buff3[1024];
	//GetWindowText(hWndCtrl, buff, 1024);
	switch
		(uMsg)
	{
		case WM_COMMAND:
		{
			if (LOWORD(wParam) == IDC_RADIO1)
			{
				if (HIWORD(wParam) == BN_CLICKED)
					draw = true;
			}

			if (LOWORD(wParam) == IDC_RADIO2)
			{
				if (HIWORD(wParam) == BN_CLICKED)
					draw = true;
			}
			
		}
		/*
			switch (LOWORD(wParam))
			{
			case IDCANCEL:
				SendMessage(hDlg, WM_CLOSE, 0, 0);
				return TRUE;
			}*/
			break;
		
	case WM_INITDIALOG:
		

		return TRUE;
		

	case WM_CLOSE:
		if (MessageBox(hDlg, TEXT("Close the program?"), TEXT("Close"),
			MB_ICONQUESTION | MB_YESNO) == IDYES)
		{
			DestroyWindow(hDlg);
		}
		return TRUE;

	case WM_DESTROY:
		PostQuitMessage(0);
		return TRUE;
	}

	return FALSE;
}
/*
INT_PTR CALLBACK DialogProc(HWND hWindow, UINT uMsg, WPARAM wParam, LPARAM lParam)
{
	switch (uMsg)
	{
	case WM_CLOSE:
		EndDialog(hWindow, 0);
		DestroyWindow(hWindow);
		return TRUE;

	case WM_INITDIALOG:
	{
		HWND hButton = GetDlgItem(hWindow, IDC_RADIO1);
		// do something if hButton == NULL
		LONG oldStyle = GetWindowLongPtr(hButton, GWL_STYLE);
		//oldStyle |= BS_SPLITBUTTON;
		SetWindowLongPtr(hButton, GWL_STYLE, oldStyle);
	}
		return TRUE;

	case WM_COMMAND:
	{
		if (LOWORD(wParam) == IDC_RADIO1)
		{
			if (HIWORD(wParam) == BN_CLICKED)
				MessageBox(0, L"Button clicked!", L"", MB_OK);
		}
	}
	return TRUE;
	}

	return FALSE;
}

*/
void displayDialog(HWND hwnd) {


	//HWND hd = CreateDialog(GetModuleHandle(NULL), MAKEINTRESOURCE(ID_DIALOG), hwnd, aboutProc);
	HWND hd;
	//hd = CreateDialogParam(ht, MAKEINTRESOURCE(IDD_DIALOG2), 0, DialogProc, 0);
	/* hd=CreateWindowW(L"DigClock",L"Dialog",WS_VISIBLE|WS_OVERLAPPEDWINDOW,400,400,200,200,hwnd,NULL,NULL,NULL);
	CreateWindowW(L"Button", L"Choose Clock",
		WS_CHILD | WS_VISIBLE | BS_GROUPBOX,
		10, 10, 120, 110, hd, (HMENU)0, g_hinst, NULL);
	button1 = CreateWindowW(L"Button", L"Aktuelle Zeit",
		WS_CHILD | WS_VISIBLE | BS_AUTORADIOBUTTON,
		20, 30, 100, 30, hd, (HMENU)IDM_MODE_AKT, g_hinst, NULL);
	CreateWindowW(L"Button", L"Vorgegeben",
		WS_CHILD | WS_VISIBLE | BS_AUTORADIOBUTTON,
		20, 55, 100, 30, hd, (HMENU)IDM_MODE_VORG, g_hinst, NULL);
 CreateWindowW(L"Button", L"Schließen",
		   WS_CHILD | WS_VISIBLE,
		   20, 80, 100, 30, hd, (HMENU) IDM_MODE_EXIT , NULL, NULL);*/
		   /*CreateWindowW(L"Button", L"schliessen",
			   WS_VISIBLE | WS_CHILD,
			   20, 80, 100, 30, hd, (HMENU)IDM_MODE_EXIT, NULL, NULL);
		   //ShowWindow(hd, 5);
		   */



}


