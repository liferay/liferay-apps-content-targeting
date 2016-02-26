@echo off

if "" == "%1" goto errorCreate

if "" == "%2" goto errorCreate

call ant -Dchannel.name=%1 -Dchannel.display.name=%2 create-channel

rem call ant deploy

goto end

:errorCreate
	echo.
	echo Usage: create_channel.bat test "Test"
	echo.
	echo The first test is your channel id. A new directory will be
	echo created based on the channel id.
	echo.
	echo The second \"Test\" is the channel\'s display name. The
	echo quotation marks are only needed because there is a space in the display
	echo name.

	goto end

:end