GET DATA  /TYPE = TXT
 /FILE = 'C:\SOAP\ProgettoCRC\ricoveri.txt'
 /DELCASE = LINE
 /DELIMITERS = ";"
 /ARRANGEMENT = DELIMITED
 /FIRSTCASE = 1
 /IMPORTCASE = ALL
 /VARIABLES =
 codice A16
 cognome A12
 nome A19
 data A11
 et� F2.1
 sesso A7
 dataRic A11
 dataDim A11
 durata A7
 DRG F7.2
 prima F4.2
 iceprima F5.2
 seconda A5
 iceseconda A5
 terza A5
 iceterza A5
 quarta A5
 icequarta A5
 NPC F2.1
 colldate A11
 creat F5.2
 CRC F6.2
 div5classi F2.1
 div2classi F2.1
 diabete F2.1
 ipertensione F2.1
 MDC F3.2
 tipo A2
 descrizione A103
 peso F7.2
 soglia F3.2
 V32 F1.0


ONEWAY
  peso BY div2classi
  /MISSING ANALYSIS .
ONEWAY
  peso BY div5classi
  /MISSING ANALYSIS .
UNIANOVA
  peso  BY div2classi  WITH et�
  /METHOD = SSTYPE(3)
  /INTERCEPT = INCLUDE
  /EMMEANS = TABLES(div2classi) WITH(et�=MEAN)
  /EMMEANS = TABLES(OVERALL) WITH(et�=MEAN)
  /PRINT = DESCRIPTIVE
  /CRITERIA = ALPHA(.05)
  /DESIGN = et� div2classi .
EXECUTE.





SCRIPT file="c:\SOAP\ProgettoCRC\o.sbs"  .
SCRIPT file="c:\SOAP\ProgettoCRC\closesyntax.sbs" . 