@echo off

if "" == "%1" goto errorCreate

if "" == "%2" goto errorCreate

call ant -Dreport.name=%1 -Dreport.display.name=%2 create-report

rem call ant deploy

goto end

:errorCreate
	echo.
	echo Usage: create_report.bat test "Test"
	echo.
	echo The first test is your consumer report id. A new directory will be
	echo created based on the consumer report id.
	echo.
	echo The second \"Test\" is the consumer report\'s display name. The
	echo quotation marks are only needed because there is a space in the display
	echo name.

	goto end

:end