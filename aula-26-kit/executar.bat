@echo off
chcp 65001 > nul
cls
echo ======================================================================
echo   AutoTech Parts • Compilando e Executando o Kit de Laboratorio
echo   Sistema Operacional: Windows 10 / 11
echo ======================================================================
echo.

where javac >nul 2>nul
if %errorlevel% neq 0 (
    echo [ERRO] O compilador javac nao foi encontrado no PATH do Windows!
    pause
    exit /b 1
)

if not exist "bin" mkdir bin

echo [1/2] Compilando as classes Java do projeto AutoTech...
javac -encoding UTF-8 -cp "lib/*" -d bin src/br/com/autotech/model/*.java src/br/com/autotech/factory/*.java src/br/com/autotech/dao/*.java src/br/com/autotech/main/*.java

if %errorlevel% neq 0 (
    echo.
    echo [ERRO] Falha durante a compilacao. Verifique a sintaxe nos metodos do PecaDao.
    pause
    exit /b 1
)

echo [2/2] Compilacao concluida com sucesso!
echo.
echo Iniciando o painel de testes interativo...
echo ======================================================================
java -cp "bin;lib/*" br.com.autotech.main.MainApp

echo.
pause
