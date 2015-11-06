#!/bin/sh

#set -x

if [ $# -lt 2 ]; then
	echo
	echo Usage: ./create_extension_report.sh test \"Test\"
	echo
	echo The first test is your extension report id. A new directory will be
	echo created based on the extension report id.
	echo
	echo The second \"Test\" is the extension report\'s display name. The
	echo quotation marks are only needed because there is a space in the display
	echo name.

	exit 127
fi

ant -Dextension.report.name=$1 -Dextension.report.display.name=\"$2\" create-extension-report

#ant deploy

exit 0