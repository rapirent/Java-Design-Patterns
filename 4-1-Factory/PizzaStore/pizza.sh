#!/bin/bash
for a in $(ls *Pizza.java)
do
    cp $a "NYStyle$a"
    mv $a "ChicagoStyle$a"
done
