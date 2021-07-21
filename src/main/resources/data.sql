INSERT INTO WowUser (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE, PHONENUMBER, DATEOFBIRTH) VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', 1, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy'), 9843514822, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy'));
INSERT INTO WowUser (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE, PHONENUMBER, DATEOFBIRTH) VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'), 9843524822, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy'));
INSERT INTO WowUser (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE, PHONENUMBER, DATEOFBIRTH) VALUES (3, 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'disabled@user.com', 0, PARSEDATETIME('01-01-2016','dd-MM-yyyy'), 9843534822, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy'));

INSERT INTO AUTHORITY (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (ID, NAME) VALUES (2, 'ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 2);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (3, 1);

INSERT INTO CATEGORY (ID, NAME) values (1, 'Stole');
INSERT INTO CATEGORY (ID, NAME) values (2, 'Bag');
INSERT INTO CATEGORY (ID, NAME) values (3, 'Pouch');


INSERT INTO PRODUCT_SUB_CATEGORY (ID, SUBTYPE, CATEGORY) VALUES (1, 'Designed Stole', 1);
INSERT INTO PRODUCT_SUB_CATEGORY (ID, SUBTYPE, CATEGORY) VALUES (4, 'Plain Stole', 1);
INSERT INTO PRODUCT_SUB_CATEGORY (ID, SUBTYPE, CATEGORY) VALUES (5, 'Raw Stole', 1);
INSERT INTO PRODUCT_SUB_CATEGORY (ID, SUBTYPE, CATEGORY) VALUES (6, 'Coloured Stole', 1);
INSERT INTO PRODUCT_SUB_CATEGORY (ID, SUBTYPE, CATEGORY) VALUES (2, 'Shopping Bag', 2);
INSERT INTO PRODUCT_SUB_CATEGORY (ID, SUBTYPE, CATEGORY) VALUES (3, 'Fashion Pouch', 3);

INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, CODE, PRICE, SIZE, CATEGORY, SUBTYPE, IMAGE_URL, CREATED_DATE, LAST_MODIFIED_DATE, CREATED_BY) 
VALUES (1, 'US Designed Stole', 'DESC', 'CODE123', 100, '12', 'Stole', 'Designed Stole', 'http://localhost:8081/static/stole.png', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);
--INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, CODE, PRICE, SIZE, CATEGORY, SUBTYPE, IMAGE_URL) 
--VALUES (2, 'India Plain Stole', 'DESC', 'CODE124', 200, '12', 'Stole', 'Plain Stole', 'http://localhost:8081/static/stole.png');
--INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, CODE, PRICE, SIZE, CATEGORY, SUBTYPE, IMAGE_URL) 
--VALUES (3, 'Large Antique Shopping Bag', 'DESC', 'CODE125', 300, '12', 'Bag', 'Shopping Bag', 'https://cdn12.picryl.com/photo/2016/12/31/bag-shopping-weave-0fa6ea-1024.png');
--INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, CODE, PRICE, SIZE, CATEGORY, SUBTYPE, IMAGE_URL) 
--VALUES (4, 'Smaller Pouch for great fashion', 'DESC', 'CODE126', 260, '12', 'Pouch', 'Fashion Pouch', 'https://c1.staticflickr.com/3/2294/5715698078_9ff3a1cd2b_b.jpg');
--INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, CODE, PRICE, SIZE, CATEGORY, SUBTYPE, IMAGE_URL) 
--VALUES (5, 'Green Awesome Stole', 'DESC', 'CODE1235', 100, '12', 'Stole', 'Designed Stole', 'http://localhost:8081/static/stole.png');
--INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, CODE, PRICE, SIZE, CATEGORY, SUBTYPE, IMAGE_URL) 
--VALUES (6, 'Traditional Stole', 'DESC', 'CODE1246', 200, '12', 'Stole', 'Plain Stole', 'http://localhost:8081/static/stole.png');
--INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, CODE, PRICE, SIZE, CATEGORY, SUBTYPE, IMAGE_URL) 
--VALUES (7, 'Leather Shopping Bag', 'DESC', 'CODE1257', 300, '12', 'Bag', 'Shopping Bag', 'https://cdn12.picryl.com/photo/2016/12/31/bag-shopping-weave-0fa6ea-1024.png');
--INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, CODE, PRICE, SIZE, CATEGORY, SUBTYPE, IMAGE_URL) 
--VALUES (8, 'Big Pouch', 'DESC', 'CODE1268', 260, '12', 'Pouch', 'Fashion Pouch', 'https://c1.staticflickr.com/3/2294/5715698078_9ff3a1cd2b_b.jpg');
--INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, CODE, PRICE, SIZE, CATEGORY, SUBTYPE, IMAGE_URL) 
--VALUES (9, 'Wow Stole', 'DESC', 'CODE1239', 100, '12', 'Stole', 'Designed Stole', 'http://localhost:8081/static/stole2.png');
--INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, CODE, PRICE, SIZE, CATEGORY, SUBTYPE, IMAGE_URL) 
--VALUES (10, 'Wow Plain Stole', 'DESC', 'CODE12410', 200, '12', 'Stole', 'Plain Stole', 'http://localhost:8081/static/stole2.png');
--INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, CODE, PRICE, SIZE, CATEGORY, SUBTYPE, IMAGE_URL) 
--VALUES (11, 'Big bag for shopping', 'DESC', 'CODE12511', 300, '12', 'Bag', 'Shopping Bag', 'https://cdn12.picryl.com/photo/2016/12/31/bag-shopping-weave-0fa6ea-1024.png');
--INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, CODE, PRICE, SIZE, CATEGORY, SUBTYPE, IMAGE_URL) 
--VALUES (12, 'Pouch for kids', 'DESC', 'CODE12612', 260, '12', 'Pouch', 'Fashion Pouch', 'https://c1.staticflickr.com/3/2294/5715698078_9ff3a1cd2b_b.jpg');

/*INSERT INTO ORDERS (ID, USER_ID, PRODUCT_INFO, AMOUNT, PAYMENT_STATUS, PAYMENT_DATE, TRANSACTION_ID, MIH_PAY_ID, PAYMENT_MODE)
VALUES (1, 1, 'PRODUCT INFO', 123, 'Success', CURRENT_DATE(), 'txn123', 'payid123', 'DC');

INSERT INTO ORDERS (ID, USER_ID, PRODUCT_INFO, AMOUNT, PAYMENT_STATUS, PAYMENT_DATE, TRANSACTION_ID, MIH_PAY_ID, PAYMENT_MODE)
VALUES (2, 2, 'PRODUCT INFO 123', 3200, 'Success', CURRENT_DATE(), 'txn1232', 'payid1232', 'DC2');


INSERT INTO ORDERS (ID, USER_ID, PRODUCT_INFO, AMOUNT, PAYMENT_STATUS, PAYMENT_DATE, TRANSACTION_ID, MIH_PAY_ID, PAYMENT_MODE)
VALUES (3, 3, 'PRODUCT INFO 3', 12, 'Success', CURRENT_DATE(), 'txn1233', 'payid1233', 'DC3');*/

INSERT INTO RATING (ID, RATING, REVIEW, USER_ID, TITLE, PRODUCT_ID) VALUES (1, 4, 'good product', 1, 'Good', 1);
--INSERT INTO RATING (ID, RATING, REVIEW, USER_ID, TITLE) VALUES (2, 5, 'good product', 2, 'Good');
--INSERT INTO RATING (ID, RATING, USER_ID, TITLE) VALUES (3, 4, 2, 'Good');
--INSERT INTO RATING (ID, RATING, REVIEW, USER_ID, TITLE) VALUES (4, 3, 'Loved it', 2, 'Good');
--INSERT INTO RATING (ID, RATING, REVIEW, USER_ID, TITLE) VALUES (5, 5, 'very nice product. Thanks to wow', 2, 'Good');


--INSERT INTO PRODUCT_RATING (PRODUCT_ID, RATING_ID) VALUES (1, 1);
--INSERT INTO PRODUCT_RATING (PRODUCT_ID, RATING_ID) VALUES (1, 2);
--INSERT INTO PRODUCT_RATING (PRODUCT_ID, RATING_ID) VALUES (1, 3);
--INSERT INTO PRODUCT_RATING (PRODUCT_ID, RATING_ID) VALUES (1, 4);
--INSERT INTO PRODUCT_RATING (PRODUCT_ID, RATING_ID) VALUES (1, 5);



INSERT INTO ADDRESS (ID, ADDRESS, STATE, CITY, PIN, USER_ID) VALUES (1, '112, Street', 'BANGALORE', 'BANGALORE', 638702, 1);

INSERT INTO ORDERS (ID, AMOUNT, PAYMENT_DATE, PAYMENT_STATUS, PRODUCT_INFO, PAYMENT_ID, PAYMENT_MODE, CART_ID, ADDRESS_ID, ORDER_STATUS, USER_ID) 
VALUES (1, 200, CURRENT_TIMESTAMP(), 'PAID', 'PRODUCT_INFO', '123212343', 'CARD', 1, 1, 'NEW', 1);

