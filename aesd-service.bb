# See https://git.yoctoproject.org/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# about how to setup ssh-agent for passwordless access
SRC_URI = "file://aesdsocket.service"


# This sets your staging directory based on WORKDIR, where WORKDIR is defined at 
# https://docs.yoctoproject.org/ref-manual/variables.html?highlight=workdir#term-WORKDIR
# We reference the "server" directory here to build from the "server" directory
# in your assignments repo

S = "${WORKDIR}"


# Add the aesdsocket application and any other files you need to install
# See https://git.yoctoproject.org/poky/plain/meta/conf/bitbake.conf?h=kirkstone

FILES:${PN} += "/opt/scripts"

# customize these as necessary for any libraries you need for your application
# (and remove comment)
SYSTEMD_SERVICE:${PN} = "aesdsocket.service"

do_install () {
  install -d ${D}/opt/scripts
	install -m 0755 ${S}/aesdsocket.service ${D}/opt/scripts	
}
