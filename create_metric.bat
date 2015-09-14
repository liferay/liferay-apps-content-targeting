@echo off

if "" == "%1" goto errorCreate

if "" == "%2" goto errorCreate

call ant -Dtracking.action.name=%1 -Dtracking.action.display.name=%2 create-tracking-action

rem call ant deploy

goto end

:errorCreate
	echo.
	echo Usage: create_metric.bat test "Test"
	echo.
	echo The first test is your metric id. A new directory will be created
	echo based on the metric id.
	echo.
	echo The second \"Test\" is the metric\'s display name. The quotation marks
	echo are only needed because there is a space in the display name.

	goto end

:end