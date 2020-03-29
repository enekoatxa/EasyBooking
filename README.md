PRO-grammers taldearen EasyBooking proiektua
===
Softwarearen Diseinua - Deustuko Unibertsitatea
===
EXEKUZIO PAUSUAK
---

1. mvn clean --> mvn compile
2. mvn datanucleus:schema-create (Datubasearen eskema sortzen du)
3. mvn exec:java -PprobaORM_1 (Datuak sartzen ditu datubasean)
4. mvn exec:java -PprobaORM_2 (Selecta querya erabilita, 73037449Y NAN a duen erabiltzailea bilatzen du)
5. mvn exec:java -PprobaORM_3 (Selecta Extenta erabilita, erabiltzaile taularen gainean)
6. mvn exec:java -PprobaORM_4 (Deletea querya erabilita, 2 bidaiari baino gehiago dituzten erreserbak ezabatzen ditu)
7. mvn exec:java -PprobaORM_5 (Updatea querya erabilita, Iberia aerolinearen izena aldatzen du)
