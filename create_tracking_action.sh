#!/bin/sh

#set -x

if [ $# -lt 2 ]; then
	echo
	echo Usage: ./create_tracking_action.sh test \"Test\"
	echo
	echo The first test is your tracking action id. A new directory will be
	echo created based on the tracking action id.
	echo
	echo The second \"Test\" is the tracking action\'s display name. The
	echo quotation marks are only needed because there is a space in the display
	echo name.

	exit 127
fi

ant -Dtracking.action.name=$1 -Dtracking.action.display.name=\"$2\" create-tracking-action

#ant deploy

exit 0