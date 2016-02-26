#!/bin/sh

#set -x

if [ $# -lt 2 ]; then
	echo
	echo Usage: ./create_report.sh test \"Test\"
	echo
	echo The first test is your report id. A new directory will be created based
	echo on the report id.
	echo
	echo The second \"Test\" is the report\'s display name. The quotation marks are
	echo only needed because there is a space in the display name.

	exit 127
fi

ant -Dreport.name=$1 -Dreport.display.name=\"$2\" create-report

#ant deploy

exit 0