@echo off

if "" == "%1" goto errorCreate

if "" == "%2" goto errorCreate

call ant -Dextension.report.name=%1 -Dextension.report.display.name=%2 create-extension-report

rem call ant deploy

goto end

:errorCreate
	echo.
	echo Usage: create_extension_report.bat test "Test"
	echo.
	echo The first test is your extension report id. A new directory will be
	echo created based on the extension report id.
	echo.
	echo The second \"Test\" is the extension report\'s display name. The
	echo quotation marks are only needed because there is a space in the display
	echo name.

	goto end

:end