--DISPLAY ALL REGION VISE COUNTRY
SELECT C.COUNTRY_NAME,R.REGION_NAME
FROM COUNTRIES C,REGIONS R
WHERE C.REGION_ID=R.REGION_ID

--DISPLAY COUNTRY WISE LOCATION
SELECT L.*,C.COUNTRY_NAME
FROM COUNTRIES C,LOCATIONS L
WHERE C.COUNTRY_ID=L.COUNTRY_ID

--REGIONS WHICH DOESNT HAVE ANY COUNTRY
SELECT C.COUNTRY_NAME,R.REGION_NAME
FROM COUNTRIES C LEFT JOIN
REGIONS R
ON C.REGION_ID=R.REGION_ID
WHERE C.REGION_ID IS NULL

--COUNTRIES WHICH DOESNT HAVE ANY LOCATION
SELECT C.COUNTRY_NAME
FROM COUNTRIES C LEFT JOIN 
LOCATIONS L
ON C.COUNTRY_ID=L.COUNTRY_ID
WHERE L.COUNTRY_ID IS NULL

--DISPLAY COUNTRY NAME AND THEIR REGION NAME
SELECT C.COUNTRY_NAME,R.REGION_NAME
FROM COUNTRIES C LEFT JOIN 
REGIONS R
ON C.REGION_ID=R.REGION_ID
ORDER BY COUNTRY_NAME ASC


--DISPLAY COUNTRY NAME REGION NAME AND LOCATION NAME
SELECT C.COUNTRY_NAME,R.REGION_NAME,L.CITY,L.STREET_ADDRESS,L.POSTAL_CODE
FROM COUNTRIES C JOIN 
REGIONS R
ON C.REGION_ID=R.REGION_ID
JOIN LOCATIONS L
ON C.COUNTRY_ID=L.COUNTRY_ID


--DISPLAY FULL ADDRESS OF SWABHAV
SELECT C.COUNTRY_NAME,R.REGION_NAME,L.CITY,L.STREET_ADDRESS,L.POSTAL_CODE
FROM COUNTRIES C JOIN 
REGIONS R
ON C.REGION_ID=R.REGION_ID
JOIN LOCATIONS L
ON C.COUNTRY_ID=L.COUNTRY_ID
WHERE L.LOCATION_ID=2000


