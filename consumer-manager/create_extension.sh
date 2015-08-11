#!/bin/sh

#set -x

if [ $# -lt 2 ]; then
	echo
	echo Usage: ./create_extension.sh test \"Test\"
	echo
	echo The first test is your extension id. A new directory will be
	echo created based on the extension id.
	echo
	echo The second \"Test\" is the extension\'s display name. The
	echo quotation marks are only needed because there is a space in the display
	echo name.

	exit 127
fi

ant -Dextension.name=$1 -Dextension.display.name=\"$2\" create-extension

#ant deploy

exit 0