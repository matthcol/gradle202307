#!/bin/bash
CONF_DIR=conf
PROPERTIES_BASEFILE=database.properties
RESOURCES_DIR=src/main/resources

function print_usage () {
	echo "Usage: $0 conf_suffix_name"
	echo ""
	echo "Example: setup project with ${CONF_DIR}/${PROPERTIES_BASEFILE}-maria"
	echo "$0 maria"
}

if [ $# -ne 1 ]
then
	echo "Missing parameter 1: conf file"
	print_usage
	exit -1
fi

CONF_FILE=${CONF_DIR}/${PROPERTIES_BASEFILE}-$1
if [ ! -f ${CONF_FILE} ]
then
	echo "Configuration file does not exist: $CONF_FILE"
	print_usage
	exit -1
fi

mkdir -p "${RESOURCES_DIR}"

DEST_FILE=${RESOURCES_DIR}/${PROPERTIES_BASEFILE}
if cp ${CONF_FILE} ${DEST_FILE}
then
	echo "Project fixed: ${CONF_FILE} -> ${DEST_FILE}" 
fi
