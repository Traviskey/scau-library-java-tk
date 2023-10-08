/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50743 (5.7.43-log)
 Source Host           : localhost:3306
 Source Schema         : scau_library_java

 Target Server Type    : MySQL
 Target Server Version : 50743 (5.7.43-log)
 File Encoding         : 65001

 Date: 08/10/2023 23:41:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admins
-- ----------------------------
DROP TABLE IF EXISTS `t_admins`;
CREATE TABLE `t_admins`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员表的唯一标识',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员账号名',
  `password` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码(MD5加密)',
  `admin_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员真实姓名',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1624 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_admins
-- ----------------------------
INSERT INTO `t_admins` VALUES (1623, 'root', 'e10adc3949ba59abbe56e057f20f883e', '是封封呀');

-- ----------------------------
-- Table structure for t_books
-- ----------------------------
DROP TABLE IF EXISTS `t_books`;
CREATE TABLE `t_books`  (
  `book_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书表唯一标识',
  `book_number` bigint(11) NOT NULL COMMENT '图书编号 图书的唯一标识',
  `book_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名称',
  `book_author` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书作者',
  `book_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书类别',
  `book_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书描述',
  PRIMARY KEY (`book_id`) USING BTREE,
  UNIQUE INDEX `t_books_book_number_uindex`(`book_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_books
-- ----------------------------
INSERT INTO `t_books` VALUES (1, 1234, '红楼梦', '曹雪芹', '小说', '《红楼梦》，原名《石头记》，中国古代章回体长篇小说，中国古典四大名著之一。');
INSERT INTO `t_books` VALUES (2, 1235, '百年孤独', '加西亚·马尔克斯', '小说', '《百年孤独》，是哥伦比亚作家加西亚·马尔克斯创作的长篇小说，是其代表作，也是拉丁美洲魔幻现实主义文学的代表作，被誉为“再现拉丁美洲历史社会图景的鸿篇巨著”。');
INSERT INTO `t_books` VALUES (3, 1236, '三体', '刘慈欣', '小说', '科幻小说，全名《地球往事三部曲》，是刘慈欣编写的史诗级巨作，是一部典型的硬科幻作品。');
INSERT INTO `t_books` VALUES (4, 1237, '战争与和平', '列夫·尼古拉耶维奇·托尔斯泰', '小说', '该作以1812年的卫国战争为中心，反映从1805到1820年间的重大历史事件。以鲍尔康斯、别祖霍夫、罗斯托夫和库拉金四大贵族的经历为主线，在战争与和平的交替描写中把众多的事件和人物串联起来');
INSERT INTO `t_books` VALUES (5, 1238, '巴黎圣母院', '雨果', '小说', '本书以1482年的法国为背景，塑造了一个个栩栩如生的形象——天真纯洁的吉普赛姑娘爱丝美拉达、年轻英俊...');
INSERT INTO `t_books` VALUES (7, 50970375442, '时间简史', '斯蒂芬·威廉·霍金', '小说', '讲述了关于宇宙本性的最前沿知识，包括：我们的宇宙图像、空间和时间、膨胀的宇宙、不确定性原理、黑洞、宇宙的起源和命运等内容，深入浅出地介绍了遥远星系、...');
INSERT INTO `t_books` VALUES (8, 78581515059, '三毛流浪记', '乐平', '儿童读物', '三毛流浪记》创作于1947年，当年在《大公报》上连载。作者凭着一只笔，几张画，无需一个文字甚至符号，把这个流浪儿童在旧社会被奴役、被欺负、被凌辱、被残踏的悲惨遭遇表现得淋漓尽致。');
INSERT INTO `t_books` VALUES (9, 74103469282, '银河帝国', '艾萨克·阿西莫夫', '科幻', '《银河帝国》，作者是艾萨克·阿西莫夫（英语：Isaac Asimov，1920年1月2日—1992年4月6日），在机器人的帮助下，人类迅速掌握了改造外星球的技术，开启了恢弘的星际殖民运动；人类在银河系如蝗虫般繁衍扩张，带着他们永不磨灭的愚昧与智慧、贪婪与良知，登上了一个个荒凉的星球，并将银河系卷入漫长的星际战国时代，直至整个银河被统一，一个统治超过2500万个住人行星、疆域横跨十万光年、总计数兆亿人口的庞大帝国崛起——银河帝国。');
INSERT INTO `t_books` VALUES (10, 7532651593, '海伯利安', '丹·西蒙斯', '科幻', '译许珀里翁、希贝里安、希佩里翁、许佩利翁、海柏利昂等，希腊神话中的泰坦十二神之一，大地女神盖亚（Gaea）和天穹之神乌拉诺斯（Uranus）之子。（十二泰坦为六男六女：河流之神俄刻阿诺斯、光明之神海伯利安、智慧之神科俄斯、时空之神克洛诺斯、生长之神克瑞斯、死亡之神伊阿佩托斯；海洋女神忒提斯、女神忒亚、月亮女神福柏、时光女神瑞亚、记忆女神谟涅摩叙涅、正义女神忒弥斯）。');
INSERT INTO `t_books` VALUES (11, 34619710875, '狼王梦', '沈石溪', '小说', '本书说的是大公狼黑桑想当狼王，和母狼紫岚一起想推翻旧狼王洛戛 [3]  ，可是这天黑桑不幸地陪同野猪丧命于鬼谷中。紫岚为黑桑生下了五个孩子，第一只在出生时，在冰冷的洪水中被冻死了。');
INSERT INTO `t_books` VALUES (14, 56029858563, '流行病的故事：从霍乱到埃博拉', '[美国] 索尼娅·沙阿', '小说', '过去数十年来，我们拥抱着工业化与全球化带来的全新生活方式，也比以往任何时候 更能感受到流行病的存在。然而，我们对流行病的认知充斥着误解、轻视或恐惧。 \n在《流行病的故事》中，屡获大奖的科普作家索尼娅·沙阿向我们展现了关于流行病鲜为人知的真相，深刻揭示了暗藏在每次疫情背后的气候、社会、文化等因素。流行病侵害着人类健康，有时甚至令国家陷入危机。但另一方面，它也改变了人类的进化轨迹，塑造了人类的行为与文明。 ');
INSERT INTO `t_books` VALUES (15, 23457140746, '危崖：生存性风险与人类的未来', '［澳］托比·奥德（Toby Ord）', '科幻', '未来100年，人类面临的生存性灾难概率是 六分之一！核战争、气候变化、生物技术、人工智能、基因工程、反乌托邦社会……哪一个最有可能让我们面临灭顶之灾？ ');
INSERT INTO `t_books` VALUES (40, 38980198460, 'SQL进阶教程（第2版）', '吴炎昌 侯振龙', '计算机', '本书是畅销书《SQL基础教程》的作者MICK为志在向中级进阶的数据库工程师编写的一本SQL技能提升指南。全书可分为两大部分。第一部分介绍了SQL语言不同寻常的使用技巧，带领读者重新认识CASE表达式、窗口函数、自连接、EXISTS谓词、HAVING子句、外连接、行间比较、集合运算、数列处理等SQL常用技术，发掘它们的新用法。这部分不仅穿插讲解了这些技巧背后的逻辑和相关知识，而且辅以丰富的示例程序，旨在帮助读者从面向过程的思维方式转换为面向集合的思维方式。第二部分介绍了关系数据库的发展史，并从集合论和逻辑');
INSERT INTO `t_books` VALUES (41, 2408369775, 'Excel机器学习', '李巧君', '计算机', '本书通过Excel示例介绍常用的机器学习算法和数据挖掘技术。许多机器学习任务的目的是找到数据中的隐藏模式。Excel能够清楚地展示机器学习建模过程的每一步及中间结果，让你不仅知其然，还知其所以然。第1章解释用Excel学习机器学习的益处。第2～12章分别介绍线性回归、k均值聚类、线性判别分析、交叉验证、logistic回归、k最近邻、朴素贝叶斯分类、决策树、关联分析、神经网络、文本挖掘。第13章总结全书内容，并为读者指出继续学习的方向。');
INSERT INTO `t_books` VALUES (43, 10242684046, '改变世界的17个方程', '劳佳', '计算机', '方程是世界的基本法则，改变了人类的命运，从波动方程、麦克斯韦方程组，到用于预测金融市场的布莱克–斯科尔斯方程，方程在生活中无处不在。毕达哥拉斯定理如何催生全球卫星定位系统？对数如何在建筑学中发挥应用？虚数为何对数码相机的发展至关重要？薛定谔的猫到底发生了什么？……\r\n本书选取17个对人类社会产生重要影响的方程，以生动有趣的笔触讲述了它们背后的历史故事，以及它们如何推动了人类文明的发展，并从数学的角度对地球万物进行了独创性的探索与阐释。');
INSERT INTO `t_books` VALUES (44, 25601652366, '学透Spring：从入门到项目实战', '', '计算机', '本书的目标是让大家又快又好地打包学透 Spring 技术栈，内容将涉及 Spring Framework、Spring Boot、 Spring Cloud 等 Spring 家族成员。 本书分为四部分：第一部分“Spring 入门”，先学习基本的 Spring IoC、AOP，随后过渡到当下热门的 Spring Boot ；第二部分“Spring 中的数据操作”，其中既有常规的 SQL、NoSQL 数据操作，也有进阶的数据源配置和缓存抽象；第三部分“使用 Spring 开发 Web 应用”，讲述 Sp');
INSERT INTO `t_books` VALUES (46, 3758465520, 'BERT基础教程：Transformer大模型实战', '周参', '计算机', '本书聚焦谷歌公司开发的BERT自然语言处理模型，由浅入深地介绍了BERT的工作原理、BERT的各种变体及其应用。本书呈现了大量示意图、代码和实例，详细解析了如何训练BERT模型、如何使用BERT模型执行自然语言推理任务、文本摘要任务、问答任务、命名实体识别任务等各种下游任务，以及如何将BERT模型应用于多种语言。通读本书后，读者不仅能够全面了解有关BERT的各种概念、术语和原理，还能够使用BERT模型及其变体执行各种自然语言处理任务。');
INSERT INTO `t_books` VALUES (47, 72721255493, '战略思维十二讲：影响关键决策的高维认知', '', '计算机', '·2016 年，很多消费电子公司的高层倡导全公司学习作者专栏文章《OPPO 和 vivo 的“人民战争”》；\r\n·2019 年，中国平安董事长马明哲针对周掌柜战略咨询团队的中国平安相关研究写了2000 多字读后感，还通过邮件群发并号召全公司20多万人阅读和学习；\r\n·德国博世、百度、OPPO、荣耀等公司曾积极评价和应用本书中的一些重要理念……\r\n\r\n成大功者，必有大战略。对于企业家来说如此，对于普通人来说亦如此。\r\n\r\n现在流行长期主义，其本质即战略稳定性，是找到了很湿的雪和很长的坡之后的滚雪球。但是，');
INSERT INTO `t_books` VALUES (49, 51561061281, '深度匹配学习：面向搜索与推荐', '朱小虎', '计算机', '本书从语义匹配的角度解决搜索引擎和推荐系统的关键痛点，为构建解决语义匹配问题的深度学习模型提供了通用框架。第1章概述搜索和推荐中的语义匹配问题，以及近年来的研究进展。第2章介绍传统匹配模型，包括潜在空间模型。第3章介绍深度学习技术在构建匹配模型时的应用。第4章和第5章分别介绍用于搜索和推荐的深度匹配模型，并将当前的深度学习解决方案分为两类：表示学习方法和匹配函数学习方法。第6章对全书内容做了总结，并为读者指明进一步学习的方向。');
INSERT INTO `t_books` VALUES (50, 32652836403, '可编程网络自动化', '门佳，李巧君', '计算机', '本书提供了可编程网络自动化的基本技能，使用了包括Linux、Python、JSON和XML在内的一系列技术。本书涵盖以下内容：Python编程基础、网络自动化所需的Linux基础、数据格式和数据模型，并介绍了Jinja模板及其在创建网络设备配置中的适用性、应用程序接口在网络自动化中的作用、使用Git进行源代码管理以在自动化过程中管理代码更改，等等。');
INSERT INTO `t_books` VALUES (51, 23911384716, '不公平优势：如何找到阻力最小的成功路径', '王小皓', '计算机', '不管是个人，还是企业，要实现目标、获得成功，往往都要先构建自己的竞争优势。有些优势是我们未曾意识到自己本就拥有的，有些优势是我们明确知道自己尚未具备的，但是怎样的优势组合才是真正有效的？本书提出了不公平优势的概念与由5种不公平优势构成的MILES框架，并结合大量案例，介绍了如何利用自己的不公平优势获得商业上的成功，同时，作为成功的创业者，两位作者还非常贴心地提供了快速创业入门指南。\r\n\r\n本书适合个人贡献者和创业者阅读。');
INSERT INTO `t_books` VALUES (52, 61573544410, '时间序列分析实战：基于机器学习和统计学', '王祎 冯英睿', '计算机', '时间序列在现代生活中无处不在，它也是数据分析的重要对象。本书介绍时间序列分析的实用技巧，展示如何结合机器学习方法和传统的统计方法来分析各类时间序列数据，并提供Python示例和R示例。本书共有17章，首先概览时间序列分析的历史，然后介绍数据的获取、清洗、模拟和存储，接着关注可用于时间序列分析的建模技术，最后探讨时间序列分析在几个常见领域中的应用。');
INSERT INTO `t_books` VALUES (54, 2383181410, '微积分溯源：伟大思想的历程', '陈见柯 林开亮 叶卢庆', '计算机', '本书讲述了一种理解和学习微积分的新思路。书中通过探索微积分发展历程背后的数学动机，展现了这一数学基本工具的魅力。作者根据自己研究和教授微积分的丰富经验，结合多年从事中学和大学数学教育的心得体会，对传统的微积分教学方式，即大多按照从极限、微分、积分到级数的顺序进行学习的方法提出了异议，探讨了一种更有趣、更易被接受和理解的学习方法。作者写过不少富有启发意义的微积分教材，此次利用自己在教学与研究方面的特长，写成了这本内容丰富、风格有趣的“小书”。本书适合中学以上水平的数学爱好者、学生和教师阅读。');
INSERT INTO `t_books` VALUES (86, 29012240157, 'BERT基础教程：Transformer大模型实战', '周参', '计算机', '本书聚焦谷歌公司开发的BERT自然语言处理模型，由浅入深地介绍了BERT的工作原理、BERT的各种变体及其应用。本书呈现了大量示意图、代码和实例，详细解析了如何训练BERT模型、如何使用BERT模型执行自然语言推理任务、文本摘要任务、问答任务、命名实体识别任务等各种下游任务，以及如何将BERT模型应用于多种语言。通读本书后，读者不仅能够全面了解有关BERT的各种概念、术语和原理，还能够使用BERT模型及其变体执行各种自然语言处理任务。');
INSERT INTO `t_books` VALUES (87, 9378134736, '深度匹配学习：面向搜索与推荐', '朱小虎', '计算机', '本书从语义匹配的角度解决搜索引擎和推荐系统的关键痛点，为构建解决语义匹配问题的深度学习模型提供了通用框架。第1章概述搜索和推荐中的语义匹配问题，以及近年来的研究进展。第2章介绍传统匹配模型，包括潜在空间模型。第3章介绍深度学习技术在构建匹配模型时的应用。第4章和第5章分别介绍用于搜索和推荐的深度匹配模型，并将当前的深度学习解决方案分为两类：表示学习方法和匹配函数学习方法。第6章对全书内容做了总结，并为读者指明进一步学习的方向。');
INSERT INTO `t_books` VALUES (88, 17015709356, '时间序列分析实战：基于机器学习和统计学', '王祎 冯英睿', '计算机', '时间序列在现代生活中无处不在，它也是数据分析的重要对象。本书介绍时间序列分析的实用技巧，展示如何结合机器学习方法和传统的统计方法来分析各类时间序列数据，并提供Python示例和R示例。本书共有17章，首先概览时间序列分析的历史，然后介绍数据的获取、清洗、模拟和存储，接着关注可用于时间序列分析的建模技术，最后探讨时间序列分析在几个常见领域中的应用。');
INSERT INTO `t_books` VALUES (89, 63868689083, '游戏化思维：从激励到沉浸', '', '计算机', '本书是通俗介绍“游戏化”的普及读物。书中通过梳理游戏化的相关研究，系统介绍了游戏化思维中的核心概念——激励和动机，并讲解了构建游戏化系统的基本要素和高级要素。作者不仅整理了经典游戏机制中的游戏化思维，还分析了社交平台、在线教育等互联网产品中对游戏化思维的运用，总结了实用的游戏化思维工具，可以帮助读者使用将其应用在工作和生活中，提升效率，增加乐趣。本书适合作为游戏化方向的研究者、培训师参考资料，也适合作游戏玩家、产品经理、教师阅读参考。');
INSERT INTO `t_books` VALUES (90, 57548855840, '用数据讲故事（修订版）', '陆昊 吴梦颖', '计算机', '本书通过大量案例研究介绍数据可视化的基础知识，以及如何利用数据创造出吸引人的、信息量大的、有说服力的故事，进而达到有效沟通的目的。具体内容包括：如何充分理解上下文，如何选择合适的图表，如何消除杂乱，如何聚焦受众的视线，如何像设计师一样思考，以及如何用数据讲故事。');
INSERT INTO `t_books` VALUES (91, 37878499145, '计算机体系结构：量化研究方法（第6版）', '贾洪峰', '计算机', '本书是权威的计算机体系结构著作，是久负盛名的经典作品。书中系统地介绍了计算机系统的设计基础、指令集系统结构、流水线和指令集并行技术、层次化存储系统与存储设备、互连网络以及多处理器系统等重要内容。这一版新增一章，专门介绍领域专用体系结构。本书对近些年火热的云计算、手机客户端技术、人工智能等相关内容也有涉猎。\r\n本书既可作为高等院校计算机专业本科生或研究生教材，也可作为从事计算机体系结构或计算机系统设计的工程技术人员的参考书。');
INSERT INTO `t_books` VALUES (92, 58736374811, '详解HTTP：协议基础与Go语言实现', '侯振龙', '计算机', '本书沿着HTTP/1.0、HTTP/1.1、HTTP/2和HTTP/3的发展历史，从方法和路径、首部、主体、状态码这4个HTTP的基本元素讲起，详细介绍了浏览器内部的动作、浏览器与服务器进行交互的方法等。针对各个版本的HTTP，分别从语法和语义两个角度，通俗易懂地讲解了HTTP的协议规范，并结合用Go语言实现的具体的客户端代码示例，为读者阐明了HTTP是如何通过功能设计和扩展来实现高速化和安全性目标的。 本书内容全面，网罗了与HTTP相关的各种技术，包括简单的HTTP访问、表单的发送、缓存和Cookie');
INSERT INTO `t_books` VALUES (94, 29585198709, '中国游戏风云', '', '计算机', '本书是系统梳理中国游戏史发展的通俗读物，书中为以时间为序，生动讲述了中国早期游戏市场、单机游戏、网络游戏、网页游戏、手机游戏及中国电子竞技行业的发展历程，描绘了中国游戏产业的演进趋势和发展脉络。此外，作者还整理、分析了游戏产业的环境变化及其影响因素，披露了大量不为大众所知的行业故事和行业数据，并结合当前市场对未来游戏世界的趋势做了预测。本书可作为游戏从业者、投资者、研究者的资料性读物，也适合游戏玩家阅读参考。');
INSERT INTO `t_books` VALUES (95, 7819287135, '面向对象是怎样工作的（第3版）', '侯振龙', '计算机', '本书以图配文的形式，直观易懂地介绍了面向对象的全貌及其包含的各项技术，包括面向对象编程、框架、设计模式、UML、建模、面向对象设计和敏捷开发方法等。对于各项技术是如何使用的（How），书中只进行简要的说明，而重点介绍这些技术是什么（What），以及为什么需要这些技术（Why）。另外，“编程往事”专栏介绍了作者年轻时的一些经历；“对象的另一面”专栏以与正文不同的视角讲解面向对象这一概念普及的背景和原因，通俗有趣；“当今的OOP”专栏介绍了Java、Python、Ruby、JavaScript等当今流行的编');
INSERT INTO `t_books` VALUES (96, 41408706970, 'Vue.js技术内幕', '', '计算机', '本书将带领读者阅读 Vue.js 3.0 的源码，通过大量注释、流程图，将每部分源码的前因后果呈现给大家，帮助工程师地体会 Vue 框架的设计思想。全书共七部分，24 章，作者结合实际用例，循序渐进地介绍了 Vue.js 的整体设计、组件、响应式原理、编译和优化、实用特性、内置组件、官方生态等内容。阅读本书不仅可以深入理解Vue.js 的内核实现，还能学习到阅读源码的技巧，提高业务逻辑分析能力和重构代码的能力。\r\n本书面向有 Vue.js、React 或者 Angular 等框架使用经验的，对源码设计感');
INSERT INTO `t_books` VALUES (97, 79237771329, 'Python深度学习（第2版）', '张亮', '计算机', '本书由流行深度学习框架Keras之父弗朗索瓦·肖莱执笔，通过直观的解释和丰富的示例帮助你构建深度学习知识体系。作者避免使用数学符号，转而采用Python代码来解释深度学习的核心思想。全书共计14章，既涵盖了深度学习的基本原理，又体现了这一迅猛发展的领域在近几年里取得的重要进展，包括Transformer架构的原理和示例。读完本书后，你将能够使用Keras解决从计算机视觉到自然语言处理等现实世界的诸多问题，包括图像分类、图像分割、时间序列预测、文本分类、机器翻译、文本生成等。');
INSERT INTO `t_books` VALUES (98, 57968293915, '趣学贝叶斯统计：橡皮鸭、乐高和星球大战中的统计学', '王凌云', '计算机', '本书通过简单的解释和有趣的示例帮助你全面了解贝叶斯统计。举几个例子：你可以评估UFO出现在自家后院中的可能性、《星球大战》中汉•索罗穿越小行星带幸存下来的可能性、抓鸭子中大奖游戏的公平性，并学会用乐高积木理解贝叶斯定理。通过阅读本书，你会学习如何衡量自己所持信念的不确定性，理解贝叶斯定理并了解它的作用，计算后验概率、似然和先验概率，计算分布以查看数据范围，比较假设并从中得出可靠的结论。');
INSERT INTO `t_books` VALUES (102, 87, '嫌疑人X', '东野圭吾', NULL, '...');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书表唯一标识',
  `card_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名称',
  `address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_status` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`order_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_systeminfo
-- ----------------------------
DROP TABLE IF EXISTS `t_systeminfo`;
CREATE TABLE `t_systeminfo`  (
  `tele` int(10) NULL DEFAULT 123456,
  `postcode` int(6) NULL DEFAULT 529800
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_systeminfo
-- ----------------------------
INSERT INTO `t_systeminfo` VALUES (123, 529800);
INSERT INTO `t_systeminfo` VALUES (123, 529800);
INSERT INTO `t_systeminfo` VALUES (123, 529800);
INSERT INTO `t_systeminfo` VALUES (123, 529800);
INSERT INTO `t_systeminfo` VALUES (123, 529800);
INSERT INTO `t_systeminfo` VALUES (123, 529800);
INSERT INTO `t_systeminfo` VALUES (123, 529800);
INSERT INTO `t_systeminfo` VALUES (123, 529800);

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `book_type_number` int(11) NOT NULL AUTO_INCREMENT,
  `book_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_type_description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`book_type_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES (98, '小说', '是以刻画人物形象为中心，通过完整的故事情节和环境描写来反映社会生活的文学体裁');
INSERT INTO `t_type` VALUES (99, '科幻', '一般认为优秀的科幻小说须具备“逻辑自洽”、“科学元素”、“人文思考”三要素。当下以叙事为重点，追求人文思考已成为科幻小说主流，科幻与奇幻小说界限日益模糊，国内科幻小说还呈现出轻科学偏文艺的趋势。');
INSERT INTO `t_type` VALUES (100, '儿童读物', '儿童读物是指少年儿童阅读的文学作品、知识读物、连环画、游戏样式读物等的总称');
INSERT INTO `t_type` VALUES (101, '计算机', '从入门到入土...');

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表的唯一标识',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码 MD5加密',
  `card_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2548 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES (2543, '是封封呀', 'e10adc3949ba59abbe56e057f20f883e', '封封', '广东省广州市华南农业大学泰山区创客空间');
INSERT INTO `t_users` VALUES (2544, '月色长眠', 'e10adc3949ba59abbe56e057f20f883e', '月月月', '华农');
INSERT INTO `t_users` VALUES (2545, '哈哈哈哈哈哈', 'e10adc3949ba59abbe56e057f20f883e', '哈哈哈', '哈哈哈');
INSERT INTO `t_users` VALUES (2546, '咦咦咦', 'e10adc3949ba59abbe56e057f20f883e', '咦咦咦', '咦咦咦');
INSERT INTO `t_users` VALUES (2547, '12', 'e10adc3949ba59abbe56e057f20f883e', '12', '12');
INSERT INTO `t_users` VALUES (2555, '天启安康', 'e10adc3949ba59abbe56e057f20f883e', '天天', '天');

SET FOREIGN_KEY_CHECKS = 1;
