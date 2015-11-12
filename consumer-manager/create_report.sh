#!/bin/sh

#set -x

if [ $# -lt 2 ]; then
	echo
	echo Usage: ./create_report.sh test \"Test\"
	echo
	echo The first test is your consumer report id. A new directory will be
	echo created based on the consumer report id.
	echo
	echo The second \"Test\" is the consumer report\'s display name. The
	echo quotation marks are only needed because there is a space in the display
	echo name.

	exit 127
fi

ant -Dreport.name=$1 -Dreport.display.name=\"$2\" create-report

#ant deploy

exit 0