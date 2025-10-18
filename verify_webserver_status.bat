@echo off
set "URL=http://127.0.0.1:5000/parabank/index.htm"
set "SLEEP_TIME=5"

:CHECK_LOOP
for /f %%i in ('curl -s -o nul -w "%%{http_code}" --max-time 5 "%URL%"') do set "HTTP_CODE=%%i"

if "%HTTP_CODE%"=="200" (
    echo %URL% 200 OK
    goto END
) else (
    echo %URL% respondio %HTTP_CODE%. Reintentando en %SLEEP_TIME% segundos...
    timeout /t %SLEEP_TIME% /nobreak >nul
    goto CHECK_LOOP
)

:END