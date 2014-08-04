#!/bin/sh

#set -x

if [ $# -lt 2 ]; then
	echo
	echo Usage: ./create.sh test \"Test\"
	echo
	echo The first test is your rule id. A new directory will be created based
	echo on the rule id.
	echo
	echo The second \"Test\" is the rule\'s display name. The quotation marks are
	echo only needed because there is a space in the display name.

	exit 127
fi

ant -Drule.name=$1 -Drule.display.name=\"$2\" create

#ant deploy

exit 0