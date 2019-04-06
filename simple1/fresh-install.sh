#!/bin/bash

rm -Rf newhome/caches/modules-2
gradle -g newhome install --scan
 
