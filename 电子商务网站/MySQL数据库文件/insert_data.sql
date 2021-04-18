INSERT INTO `tb_customer` VALUES ('1', '1', '无名', '男', '1323434', '江西省南昌市南昌航空大学', 1342220000);

INSERT INTO `tb_shoppingcart` VALUES ('1', '1');

INSERT INTO `tb_merchant` VALUES ('2', '2', '管理员1', '10086');

INSERT INTO `tb_shop` VALUES ('S001', '品牌数码店', '数码', '江西省南昌市');

INSERT INTO `tb_goods` VALUES ('G001', '小米10', '数码', '手机', 3999, '向往的生活同款 / 骁龙865处理器 / 1亿像素8K电影相机 / 双模5G / 新一代LPDDR5内存 / 对称式立体声 / 90Hz刷新率+180Hz采样率 / UFS 3.0高速存储 / 全面适配Wi-Fi 6 / 超强VC液冷散热 / 30W极速闪充+30W无线闪充+10W无线反充 / 4780mAh大电量 / 多功能NFC', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1581494372.61732687.jpg');
INSERT INTO `tb_goods` VALUES ('G002', '腾讯黑鲨游戏手机3', '数码', '手机', 4999, '骁龙865处理器 / 双模5G+WiFi6 / 升降式机械游戏按键 / 2K+超清分辨率 / 腾讯Solar Core游戏引擎 / 270Hz触控采样率+90Hz屏幕刷新率 / 最高65W极速闪充+背部磁吸充电 / 5000mAh大容量双电池 / UFS3.0闪存+LPDDR5 / “三明治”液冷散热 / 屏幕压感3.0 / 游戏语音操控', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1582886257.89939644.jpg');
INSERT INTO `tb_goods` VALUES ('G003', 'Redmi Note 8', '数码', '手机', 999, '\r\n4800万全场景四摄 / 前置1300万美颜相机 / 骁龙665处理器 / 4000mAh超长续航 / 标配18W快充 / 超线性扬声器 / 90%高屏占比 / 康宁大猩猩保护玻璃 / 6.3英寸水滴全面屏', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1585724658.11257831.jpg');

INSERT INTO `tb_stock` VALUES ('G001', 'S001', 194, 13);
INSERT INTO `tb_stock` VALUES ('G002', 'S001', 95, 8);
INSERT INTO `tb_stock` VALUES ('G003', 'S001', 198, 2);

INSERT INTO `tb_order` VALUES ('11593517210177', '1', '2020-6-30 11:40:10', NULL, '已完成', 3999);

INSERT INTO `tb_odetails` VALUES ('11593517210297', '11593517210177', 'G001', 1, 3999);




