#!/bin/sh

#set -x

if [ $# -lt 2 ]; then
	echo
	echo Usage: ./create_channel.sh test \"Test\"
	echo
	echo The first test is your channel id. A new directory will be
	echo created based on the channel id.
	echo
	echo The second \"Test\" is the channel\'s display name. The
	echo quotation marks are only needed because there is a space in the display
	echo name.

	exit 127
fi

ant -Dchannel.name=$1 -Dchannel.display.name=\"$2\" create-channel

#ant deploy

exit 0