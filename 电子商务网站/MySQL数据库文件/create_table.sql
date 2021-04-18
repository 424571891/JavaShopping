-- 商家表tb_Merchant
CREATE TABLE tb_Merchant
(	  Mno VARCHAR(30) NOT NULL,
		Mpassword VARCHAR(30) NOT NULL,
	  Mname VARCHAR(30) NOT NULL,
		Mtel  VARCHAR(30) NOT NULL,
	  PRIMARY KEY(Mno)
);

-- 顾客表tb_Customer
CREATE TABLE tb_Customer
(	  Cno VARCHAR(30) NOT NULL,
		Cpassword VARCHAR(30) NOT NULL,
	  Cname VARCHAR(30) NOT NULL,
	  Csex VARCHAR(30) CHECK(Csex IN('男','女')),
	  Ctel VARCHAR(30),
	  Caddress VARCHAR(300) ,
		Cbalance Float(2) NOT NULL CHECK(Cbalance >= 0),
	  PRIMARY KEY(Cno)
);

-- 店铺表tb_Shop
CREATE TABLE tb_Shop
(	  Sno VARCHAR(30) NOT NULL,
	  Sname VARCHAR(30) NOT NULL,
	  Stype VARCHAR(30) NOT NULL,
	  Saddress VARCHAR(300) NOT NULL, 
	  PRIMARY KEY(Sno)
);

-- 商品信息表tb_Goods
CREATE TABLE tb_Goods
(	  Gno VARCHAR(30) NOT NULL,
	  Gname VARCHAR(30) ,
	  Gtype VARCHAR(30) NOT NULL,
	  Gconcrete_type VARCHAR(30) NOT NULL, 
	  Gprice FLOAT NOT NULL CHECK(Gprice >= 0),
	  Gmessage VARCHAR(400) NOT NULL,
		Gimage VARCHAR(200) NOT NULL,
	  PRIMARY KEY(Gno)
);

-- 店铺库存表tb_Stock(一种商品只能放在一个店铺里)
CREATE TABLE tb_Stock
(		Gno VARCHAR(30) NOT NULL,
		Sno VARCHAR(30) NOT NULL,
	  STnum INT NOT NULL CHECK(STnum >= 0),
		STsales_num INT NOT NULL CHECK(STsales_num >= 0),
	  PRIMARY KEY(Gno),
	  FOREIGN KEY (Sno) REFERENCES tb_Shop(Sno),
	  FOREIGN KEY (Gno) REFERENCES tb_Goods(Gno)
);

-- 订单总表tb_Order
CREATE TABLE tb_Order
(	  Ono VARCHAR(30) NOT NULL,
	  Cno VARCHAR(30) NOT NULL,
	  Otime_create TIMESTAMP NOT NULL,
	  Otime_complete TIMESTAMP,
	  Ostatus VARCHAR(30) NOT NULL, 
	  Oprice FLOAT(2) NOT NULL CHECK(Oprice >= 0),
	  PRIMARY KEY(Ono),
	  FOREIGN KEY (Cno) REFERENCES tb_Customer(Cno)
);

-- 订单明细表tb_ODetails
CREATE TABLE tb_ODetails
(	  ODno VARCHAR(30) NOT NULL,
	  Ono VARCHAR(30) NOT NULL,
	  Gno VARCHAR(30) NOT NULL,
	  ODnum INT NOT NULL CHECK(ODnum > 0),
	  ODprice FLOAT NOT NULL CHECK(ODprice >= 0), 
	  PRIMARY KEY(ODno),
	  FOREIGN KEY (Ono) REFERENCES tb_Order(Ono),
	  FOREIGN KEY (Gno) REFERENCES tb_Goods(Gno)
);

-- 购物车表tb_ShoopingCart
CREATE TABLE tb_ShoppingCart
(	  SCno VARCHAR(30) NOT NULL,
	  Cno VARCHAR(30) NOT NULL,
	  PRIMARY KEY(SCno),
	  FOREIGN KEY (Cno) REFERENCES tb_Customer(Cno)
);

-- 购物车明细表tb_SCDetails
CREATE TABLE tb_SCDetails
(	  SCDno VARCHAR(30) NOT NULL,
	  SCno VARCHAR(30) NOT NULL,
	  Gno VARCHAR(30) NOT NULL,
	  SCDnum INT NOT NULL CHECK(SCDnum > 0),
	  PRIMARY KEY(SCDno),
	  FOREIGN KEY (SCno) REFERENCES tb_ShoppingCart(SCno),
	  FOREIGN KEY (Gno) REFERENCES tb_Goods(Gno)
);
