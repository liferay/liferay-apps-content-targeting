@echo off

if "" == "%1" goto errorCreate

if "" == "%2" goto errorCreate

call ant -Drule.name=%1 -Drule.display.name=%2 create-rule

rem call ant deploy

goto end

:errorCreate
	echo.
	echo Usage: create_rule.bat test "Test"
	echo.
	echo The first test is your rule id. A new directory will be created based
	echo on the rule id.
	echo.
	echo The second \"Test\" is the rule\'s display name. The quotation marks are
	echo only needed because there is a space in the display name.

	goto end

:end