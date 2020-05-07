CREATE TABLE customer (
customer_id INT PRIMARY KEY, 
first CHAR(20), 
middle CHAR(20), 
last CHAR(20)
);
INSERT INTO customer VALUES(1, Paul, Lenoard, Munce);
INSERT INTO customer VALUES(2, Gregory, Judah, Bottz);
INSERT INTO customer VALUES(3, Nicole, Jane, Dimsum);
INSERT INTO customer VALUES(4, Stephen, Wycliff, Lim);
INSERT INTO customer VALUES(5, Naomi, Sarah, Supat);
INSERT INTO customer VALUES(6, Mark, Ian, SooHoo);
INSERT INTO customer VALUES(7, Dietrich, Piper, Bonhof);
INSERT INTO customer VALUES(8, Hoiyun, Wah, Sitou);
INSERT INTO customer VALUES(9, Imbioua, NULL, Oderanda);
INSERT INTO customer VALUES(10, Gerald, Jordan, Morla);
INSERT INTO customer VALUES(11, Shelly, Shelby, Bonde);
INSERT INTO customer VALUES(12, Sudarshan, Ash, Jugarappua);
INSERT INTO customer VALUES(13, Juan, Jose, Orozco-Cortez);
INSERT INTO customer VALUES(14, Ni, Yohei, Ochiai);
INSERT INTO customer VALUES(15, Edwin, Mark, Raj);

CREATE TABLE home (
home_id INT PRIMARY KEY,  
number_of_rooms INT CHECK(number_of_rooms > 0), 
street CHAR(35), city CHAR(20), 
state CHAR(20), 
zip NUMERIC(5, 0)
); 
INSERT INTO home VALUES(1, 3, 2813 Ben Reed Rd, San Jose, CA, 95112);
INSERT INTO home VALUES(2, 4, 837 S. 4th Street Apartment 641, San Jose, CA, 95112 );
INSERT INTO home VALUES(3, 4, 67547 Khayrallah Street, Berkeley, AL, 334867 );
INSERT INTO home VALUES(4, 3, 7324 Yazdankhah Blvd, Diego, TX, 82736 );
INSERT INTO home VALUES(5, 2, 972 Heller Court, Riverside, NM, 9872 );
INSERT INTO home VALUES(6, 1, 128 Pearce Street, San Fran, VA, 93877 );
INSERT INTO home VALUES(7, 2, 164 Fairfield Rd. Easton, PA, 18042);
INSERT INTO home VALUES(8, 3, 8413 San Pablo St. Virginia Beach, VA, 23451);
INSERT INTO home VALUES(9, 5, 913 E. Halifax Drive Muscatine, IA, 52761);
INSERT INTO home VALUES(10, 8, 8664 High Court Martinsville, VA, 24112);
INSERT INTO home VALUES(11, 2, 9800 Lexington St. Parkville, MD, 21234);
INSERT INTO home VALUES(12, 4, 833 Valley View Dr. Dayton, OH, 45420);
INSERT INTO home VALUES(13, 5, 893 Wild Horse Drive Libertyville, IL, 60048 );
INSERT INTO home VALUES(14, 3, 7039 N. Mill Street Zionsville, IN, 46077 );
INSERT INTO home VALUES(15, 4, 158 Briarwood St. Glen Cove, NY, 11542);

CREATE TABLE incident (
incident_id INT PRIMARY KEY, 
month NUMERIC(2, 0) CHECK(month => 1 && month <= 12), 
year NUMERIC(4, 0), 
time INT, 
classification CHAR(20)
); 
INSERT INTO incident VALUES(79,4,2019,2300,10);
INSERT INTO incident VALUES(23,5,2015,1532,10);
INSERT INTO incident VALUES(34,5,2015,1620,7);
INSERT INTO incident VALUES(84,6,2019,1536,6);
INSERT INTO incident VALUES(63,8,2019,2211,8);
INSERT INTO incident VALUES(92,10,2017,144,5);
INSERT INTO incident VALUES(12,3,2019,1634,2);
INSERT INTO incident VALUES(88,8,2015,222,4);
INSERT INTO incident VALUES(99,10,2016,1930,10);
INSERT INTO incident VALUES(81,12,2015,346,3);
INSERT INTO incident VALUES(51,6,2016,2113,2);
INSERT INTO incident VALUES(99,1,2015,1557,7);
INSERT INTO incident VALUES(4,1,2019,329,1);
INSERT INTO incident VALUES(78,8,2018,839,8);
INSERT INTO incident VALUES(2,6,2020,2215,5);

 CREATE TABLE policy (
policy_id INT PRIMARY KEY, 
price NUMERIC(4, 2) CHECK(price > 0), 
coverage INT NOT NULL
); 
INSERT INTO policy VALUES(1, 615.23, 2 );
INSERT INTO policy VALUES(2, 1567.23 , 1);
INSERT INTO policy VALUES(3, 3340.00, 6);
INSERT INTO policy VALUES(4, 369.03, 4);
INSERT INTO policy VALUES(5, 1230.46 , 2);
INSERT INTO policy VALUES(6, 3340.00, 6);
INSERT INTO policy VALUES(7, 1589.53, 5);
INSERT INTO policy VALUES(8, 2083.12, 1);
INSERT INTO policy VALUES(9, 2897.73, 9);
INSERT INTO policy VALUES(10, 10247.97, 10);
INSERT INTO policy VALUES(11, 400.62, 5);
INSERT INTO policy VALUES(12, 450.78, 7);
INSERT INTO policy VALUES(13, 615.23, 2);
INSERT INTO policy VALUES(14, 2083.12, 8);
INSERT INTO policy VALUES(15, 369.03, 4);

CREATE TABLE payments (
policy_id INT PRIMARY KEY FOREIGN KEY(policy_id) REFERENCES policy(policy_id), 
due_date DATE, 
amt NUMERIC(4, 2) CHECK(amt > 0), 
coverage_time_period INTCHECK(coverage_time_period  => 12,
effective_date DATE CHECK(effective_date < expiration_date), 
expiration_date DATE 
); 
INSERT INTO payments VALUES(1, 2020-02-09, 51.27, 12, 2020-01-09, 2021-02-09 );
INSERT INTO payments VALUES(2, 2020-03-26, 130.60, 12, 2020-02-26, 20211-03-26);
INSERT INTO payments VALUES(3, 2020-09-02, 139.17, 24, 2020-08-02, 2022-09-02);
INSERT INTO payments VALUES(4, 2020-12-10, 30.75, 12, 2020-11-10, 2021-12-10);
INSERT INTO payments VALUES(5, 2020-08-28, 51.27, 24, 2020-07-28, 2022-08-28 );
INSERT INTO payments VALUES(6, 2020-02-03, 139.17, 24, 2020-01-03, 2022-02-03);
INSERT INTO payments VALUES(7, 2020-04-12, 132.46, 12, 2020-03-12, 2021-04-12);
INSERT INTO payments VALUES(8, 2020-05-22, 173.60, 12, 2020-04-22, 2021-05-22);
INSERT INTO payments VALUES(9, 2020-03-28, 241.48, 12, 2020-02-28, 2021-03-28);
INSERT INTO payments VALUES(10, 2020-11-15, 284.67, 36, 2020-10-15, 2023-11-15);
INSERT INTO payments VALUES(11, 2020-06-06, 16.69, 24, 2020-05-06, 2022-06-06);
INSERT INTO payments VALUES(12, 2020-08-03, 37.57, 12, 2020-07-03, 2021-08-03);
INSERT INTO payments VALUES(13, 2020-10-28, 51.27, 12, 2020-09-28, 2021-10-28 );
INSERT INTO payments VALUES(14, 2020-06-22, 173.59, 12, 2020-05-22,  2021-06-22);
INSERT INTO payments VALUES(15, 2020-12-16, 30.75, 12, 2020-11-16, 2021-12-16);

CREATE TABLE covers (
home_id INT, 
policy_id INT
); 

CREATE TABLE owns (
customer_id INT,
home_id INT
); 


