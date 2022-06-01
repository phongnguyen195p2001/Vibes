CREATE DATABASE `eproject2`;
USE `eproject2`;

CREATE TABLE `contact` (
	`contactId` INT(11) UNSIGNED AUTO_INCREMENT  PRIMARY KEY,
	`name` VARCHAR(50) COLLATE utf8_unicode_ci NOT NULL,
	`phone` VARCHAR(12) COLLATE utf8_unicode_ci NOT NULL,
	`email` VARCHAR(50) COLLATE utf8_unicode_ci NOT NULL,
	`feedback` TEXT COLLATE utf8_unicode_ci
);

CREATE TABLE `admin` (
	`adminId` INT(11) AUTO_INCREMENT  PRIMARY KEY,
	`userName` VARCHAR(50) COLLATE utf8_unicode_ci NOT NULL,
	`password` VARCHAR(200) COLLATE utf8_unicode_ci NOT NULL,
	`fullName` VARCHAR(100) COLLATE utf8_unicode_ci NOT NULL,
	`phone` VARCHAR(12) COLLATE utf8_unicode_ci NOT NULL,
	`email` VARCHAR(50) COLLATE utf8_unicode_ci NOT NULL
);

CREATE TABLE `user` (
	`userId` INT(11) AUTO_INCREMENT  PRIMARY KEY,
	`name` VARCHAR(50) COLLATE utf8_unicode_ci NOT NULL,
	`userName` VARCHAR(50) COLLATE utf8_unicode_ci NOT NULL,
	`password` VARCHAR(200) COLLATE utf8_unicode_ci NOT NULL,
	`phone` VARCHAR(12) COLLATE utf8_unicode_ci NOT NULL,
	`email` VARCHAR(50) COLLATE utf8_unicode_ci NOT NULL
);

CREATE TABLE `brand`(
	`brandId` INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
	`brand` VARCHAR(50) COLLATE utf8_unicode_ci NOT NULL,
	`logo` VARCHAR(200) COLLATE utf8_unicode_ci NOT NULL
);

CREATE TABLE `style` (
	`styleId` INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`styleName` VARCHAR(50) COLLATE utf8_unicode_ci NOT NULL
);

CREATE TABLE `motor` (
	`motorId` INT(11) AUTO_INCREMENT PRIMARY KEY,
	`motorName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
	`image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  	`descriptionImg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
	`price` FLOAT(12) NOT NULL,
	`engine` INT(10) COLLATE utf8_unicode_ci NOT NULL,
	`introduce` TEXT COLLATE utf8_unicode_ci DEFAULT NULL,
	`brandMotor` INT(10) UNSIGNED NOT NULL,
	`styleMotor` INT(10) UNSIGNED NOT NULL,
	INDEX `fk_brand` (`brandMotor`) USING BTREE,
	INDEX `fk_style` (`styleMotor`) USING BTREE,
	CONSTRAINT `fk_brand` FOREIGN KEY (`brandMotor`) REFERENCES `brand` (`brandId`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `fk_style` FOREIGN KEY (`styleMotor`) REFERENCES `style` (`styleId`) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO `motor` (`motorName`, `image`, `descriptionImg`, `price`, `engine`, `introduce`, `brandMotor`, `styleMotor`) VALUES
	('BMW S1000RR', 's1000rr.jpg', 's1000rrbiker.jpg', 43827.35, 999, 'The newly designed, four-cylinder engine is the new RR power train. 
	Not only was the peak output increased to 205 HP at 13,000 rpm, but the torque curve was also optimized. 
	Thanks to the new BMW ShiftCam technology, which selects the valve opening time and the valve lift by means of the camshaft, significantly more torque and power is applied even in low and medium engine speed ranges.', 1, 1),
	('BMW S1000R', 'bmws1000r.png', 's1000rbiker.jpg', 14529.99, 999, 'The high-performance 4-cylinder in-line engine, just like the rear, descends from the RR. For an extremely linear torque and constant forward propulsion across the entire engine speed range. 
	Throttle-by-wire lets you measure out this power even more precisely. The Gear Shift Assist Pro lets you shift up and down without using the clutch for more dynamics and shorter response times.', 1, 2),
	('BMW S1000XR', 'bmws1000xr.jpg', 's1000xrbiker.jpg', 17427.45, 999, 'Dynamism is also a question of mass. 
	Even fully equipped, the S 1000 XR weighs a full 22 lbs less than its predecessors. In the lightest configuration, this bike is ready to ride at just 498 lbs. 
	You won\'t miss a single ounce, but you will feel each individual one – on every yard. 
	In the form of better acceleration, higher agility, shorter braking distances, and easier maneuvering.', 1, 4),
	('BMW R NineT', 'NineT.jpg', 'NineTbiker.jpg', 12579.55, 1170, 'The 2020 BMW R nineT Scrambler takes the standard bike that is the regular R nineT and crafts it into a bike that looks like a scrambler motorcycle. 
	The bike features retro-inspired styling and is mostly the same as the regular R nine-T but with some aesthetic changes like a different exhaust and a saddle brown seat.
	The model features a 1,170cc boxer engine that makes 110 hp and 86 lb-ft of torque. 
	The air-cooled engine does the job fine, but what really sets this bike apart is its styling. This machine isn\'t a true scrambler, but it can take on some gravel roads. 
	It\'ll do that while being really, really good looking, too.', 1, 5),
	('BMW R1200GS', 'r1200sg.jpg', 'r1200sgbiker.jpg', 24379.75, 1200, 'The BMW R 1200 GS: concentrated performance meets impressive efficiency. With the BMW R 1200 GS you will experience the Boxer even more directly. 
	An increase in engine displacement brings you even more performance – pumping out 136 hp and 105 lb-ft of torque. BMW ShiftCam variable camshaft control system ensures consistent power delivery – throughout the entire power band. 
	Whether in the city, on the motorway, or off road, every mile gives you more freedom and riding pleasure. Unique styles and colors, numerous technical details, and exciting individualization options combine to bring you the BMW R 1200 GS.', 1, 4),
	('BMW G310R', 'g310r.jpg', 'g310rbiker.jpg', 8965.19, 313, 'The BMW G 310 R is the essence of riding pleasure. It was built for pulsing cities and those who simply love riding motorcycles. It is maneuverable, easy to handle and sporty at the same time. 
	Regardless of your height, you\'ll immediately feel at home on the BMW G 310 R. The bike is lightweight, yet a real powerhouse with its 313 cc engine. Get to work, the next hot spot or out of the city safely and reliably on the G 310 R. 
	Premium quality, excellent workmanship and extraordinary technology ensure intense riding pleasure. ', 1, 2);

INSERT INTO `motor` (`motorName`, `image`, `descriptionImg`, `price`, `engine`, `introduce`, `brandMotor`, `styleMotor`) VALUES
('Ducati Panigale V4S', 'v4s.jpg', 'v4sbiker.jfif', 52379.49, 998, 'Ducati Panigale V4 S spun its rear wheel on our in-house dyno, producing gobs of power: 186 hp at 13,320 rpm and 79.6 pound-feet of torque at 11,310 rpm in fact. 
If that\'s not enough for you, then look toward the homologation special superbike, the 2019 Panigale V4 R: 203.99 hp at 15,820 rpm and 76.65 pound-feet of torque at 12,300 rpm is eyes-pushed-to-the-back-of-your-skull, skin-peeling power.', 2, 1),
('Ducati 1200', 'monster.jfif', 'monsterbiker.jpg.', 18627.55, 1200, 'The Monster 1200 has always been a symbol in the world of sporty naked bikes thanks to the details that make it unmistakable. 
In the S version, the new Black on Black color with matte and glossy black elements, enhances its sporty lines and character. ', 2, 2),
('Ducati Diavel', 'diavel.jpg', 'diavel.jfif', 36827.39, 1262, 'Ducati\'s muscular sports cruiser is one of the most exciting motorcycles on the market. It\'s the successful fusion of a naked street bike with the presence and comfort of a modern power cruiser. 
Big in power, huge in character, and absolutely stunning to look at, the Ducati Diavel 1260 is unlike anything else on the scene.', 2, 3),
('Ducati 1199 Panigale', '1199.jpg', '1199biker.jpg', 56135.99, 1198, 'At the time of its release Ducati claimed that the 1199 Panigale was the world\'s most powerful production twin-cylinder engine motorcycle, with 195 bhp (145 kW) at 10,750 rpm, torque at 9000 rpm on an engine test stand.
 With a claimed dry weight of 164 kg (362 lb) and a curb weight of 188 kg (414 lb). Ducati said the 1199 had the highest power-to-weight and torque-to-weight ratios of production motorcycles.', 2, 1),
('Ducati Multistrade', 'multistrada.jpg', 'multistrada.jfif', 27489.00, 1260, 'The new Multistrada 1260 truly maximizes the concept of versatility: The new 1262 cc Ducati Testastretta DVT engine extends powers even in low gear, the new chassis and cutting-edge electronics improve control and ease of driving in any condition and on any road.', 2, 4);

INSERT INTO `motor` (`motorName`, `image`, `descriptionImg`, `price`, `engine`, `introduce`, `brandMotor`, `styleMotor`) VALUES
('Yamaha TFX', 'tfx.jpg', 'tfxbiker.jpg', 3647.33, 149, 'This is the embodiment classy duality with each ride; a showcase of true character. It is freedom expressed through style and grace married to unadulterated torque. 
Self - ruling and unprejudiced, this motorcycle is the manifestation of unwavering authenticity.
Show the city streets who you really are, unleash yourself with the TFX 150', 5, 2),
('Yamaha YZF R6', 'r6.jpg', 'r6biker.jpg', 27815.59, 599, 'Featuring low-drag bodywork and an aggressive look that bears all the characteristics of Yamaha\'s thoroughbred R-series DNA, the new R6 has arrived.
And to give you the ability push even harder, the new R6 comes with a 6-mode Traction Control System, as well as a Quick Shifter System (QSS) and ABS.', 5, 1),
('Yamaha MT03', 'mt03.jfif', 'mt03biker.jfif', 7859.19, 321, 'Yamaha\'s dynamic MT-03 represents the new wave in motorcycle design. A sporty and versatile character comes together with an upright riding position and compact dimensions to make this naked lightweight an ideal choice for new, returning and upgrading riders.', 5, 2),
('Yamaha YZF R1', 'r1.jpg', 'r1biker.jpg', 37499.99, 999, 'Equipped with an aggressive new M1-derived cowl, the more aerodynamic bodywork delivers ultimate performance. Next generation LED headlights and restyled LED position lights reinforce this bike\'s intimidating presence – and with the new Brake Control (BC) and Engine Brake Management (EBM) systems, you\'re in full control.', 5, 1),
('Yamaha Bolt', 'bolt.jpg', 'boltbiker.jpg', 13275.45, 942, 'The slim body and low seat design combine to give the motorcycle light maneuverability and a stable handling feeling. The upright riding posture helps the rider feel the wind, hear the sounds and experience the pulse of the machine.', 5, 3),
('Yamaha MT10', 'mt10.jpg', 'mt10biker.jpg', 20399.49, 997, 'While European manufacturers are one-upping each other with upright naked open-class sportbikes that get more outlandishly powered and knife-edge handling, Yamaha has focused on making the YZF-R1 superbike based 2020 Yamaha MT-10 an effective street-going motorcycle. 
While it might not be your choice when going to the track, you will be fully satisfied with its performance in canyons, mountain roads, and in urban confines.', 5, 2),
('Kawasaki Z1000', 'z1000.jpeg', 'z10000.jfif', 17468.39, 1043, 'Stripped off of all unnecessary flourishes, the Z1000 Edition is darker, meaner and more beastly than ever. Intensely imbued with Sugomi, this mean machine was designed to inspire awe and commands respect.
Powered by a 1,043cc, liquid-cooled, 4-stroke, in line four engine, the Z1000 Edition was built to conquer lesser riders on the road. Equipped with ABS, coupled by brembo brakes and calipers, the Z1000 Edition boasts of incredible stopping power than can rival even the strongest superbike.', 3, 2),
('Kawasaki ZX10R', 'zx10r.jpg', 'zx10rbiker.jpg', 28319.99, 998, 'The 2020 Kawasaki ZX10R is the latest evolution of a long running model series that started 15 years ago in 2004. Through 8 evolutions, the ZX10R now boasts a 998cc DOHC inline 4 producing 197 crank HP and 84 lbs-ft of crank torque, allowing the motorcycle to reach 60 MPH in a stunning 2.8 seconds.', 3, 1),
('Kawasaki Z650', 'z650.jfif', 'z650biker.jfif', 13672.49, 649, 'The 2020 Kawasaki Z650, much like its bigger brother the Z900, is a very young model, having been introduced only in 2017. Powered by a 64cc DOHC liquid cooled parallel twin, the Z650 produces 68 crank HP and 48.5 lbs-ft of crank torque. 
That may not sound like much, however the Z650 takes weight reduction seriously and comes in at a full wet weight of only 412 lbs.', 3, 2),
('Kawasaki H2R', 'h2r.jpg', 'h2rbiker.jpg', 53489.59, 998, 'Pushing engineering and performance boundaries is one of the few motorcycles that truly deserve to be called Instant Icons. Created without compromise and benefiting from the collective strength of Kawasaki Heavy Industries, the Ninja H2R demands respect and attracts the most skilled and committed riders.', 3, 1),
('Kawasaki ZX6R', 'zx6r.jpeg', 'zx6rbiker.jpg', 23979.75, 636, 'The 2020 Kawasaki ZX6R comes from a long line of successful supersport motorcycles that were introduced to the world in 1995. 11 generations of engineering and evolution have led to the ZX6R having a 636 cc inline 4 engine that produces 127 crank HP and 52 lbs-ft of crank torque.', 3, 1),
('Harley-Davidson Ultra', 'ultralimiter.jpg', 'ultrabiker.jpg', 61346.59, 1868, 'Price, if shown and unless otherwise noted, represents the Manufacturer\'s Suggested Retail Price (MSRP) or dealer unit price and does not include government fees, taxes, dealer vehicle freight/preparation, dealer document preparation charges, labor, installation, or any finance charges (if applicable). 
MSRP and/or final sales price will vary depending on options or accessories selected; contact dealer for more details.', 4, 4),
('Harley-Davidson Iron 883', 'roadster.jpg', 'roadsterbiker.jpg', 17899.69, 883, 'Authentic Harley-Davidson style through and through, dripping with power. The rubber-mounted 883cc Evolution engine runs hard and rides smooth for thousands of miles so you can just worry about taking in the freedom of boulevards and back streets. ', 4,3 ),
('Honda CBR1000RR', 'cbr1000rr.jpg', 'cbr1000rrbiker.jpg', 32546.99, 999, 'What you see here is the best of the best, the most exclusive, feature-rich open-class sportbike Honda has ever built under the CBR banner. Introducing the limited edition CBR1000RR-R Fireblade SP. Street legal, but track ready.', 7, 1),
('Honda Rebel', 'rebel.jpg', 'rebelbiker.jpg', 8349.35, 471, 'When the Honda Rebel 500 debuted just a few years ago, riders everywhere loved the way it combined a fresh, blacked-out look with timeless features like a low seat height, light weight, narrow 471cc parallel-twin engine and user-friendly powerband. And for 2020 we kept all those best parts, but have given the Rebel 500 some impressive upgrades, like a LED lighting package.', 7, 3),
('Honda Goldwing', 'goldwing.jpg', 'goldwingbiker.png', 55327.99, 1832, 'Synonymous with long range comfort, luxury and quality for over 40 years, the Gold Wing was redesigned from the wheels up for 2018 to be sharper, lighter and more compact, while maintaining its reputation as a technological flagship with numerous new features including the first adoption of Apple CarPlay on a motorcycle.', 7, 4),
('Honda CB1000R', 'cb1000r.jpeg', 'cb1000rbiker.jpg', 28916.48, 998, 'An inline-four streetbike is truly a thing of beauty. It\'s all business, and you never get tired looking at it. Simply put, the Honda CB1000R is the best open-class naked streetfighter we\'ve ever produced. It has cutting-edge Neo-Sports Café styling, and a high-revving 998cc four-cylinder engine that\'s specially tuned for midrange and top-end power.', 7, 2),
('Honda CBR600RR', 'cbr600rr.jpg', 'cbr600rrbiker.jpg', 23641.15, 599, 'Honda\'s 2020 CBR600RR is a bike that puts the \"Super\" in Supersport. Six-hundreds have always been magic machines, combining sharp handling with light weight and plenty of performance. And there\'s nothing like a high-revving inline four when it comes to immediate, exhilarating power delivery.', 7, 1),
('Suzuki R1000R', 'r1000r.jpg', 'r1000rbiker.jpg', 29898.39, 998, 'The 2020 Suzuki GSX-R1000R is one of Suzuki\'s most sporty bikes in its lineup. It was crafted to be one the King of the Sportbikes. The bike is designed and built for a rider with some serious sport riding skills. It\'s at home on the racetrack or a twisty canyon road where you can really get after it.', 6, 1),
('Suzuki GZ150', 'gz150.jpg', 'gz150biker.jpg', 4468.39, 150, ' 	Suzuki GZ150 is a Brazil-spec model, it was expected that it would be coming to India but as per the latest details and brochure leaks, it seems like Suzuki designed an all-new cruiser motorcycle under the Intruder nameplate, specifically for the Indian market.', 6, 3),
('Suzuki S750', 's750.jpg', 's750biker.jfif', 26764.49, 748, 'Powered by a legendary supersport engine. Armed with the latest technologies. Tuned to command the streets. Built to reign supreme over naked sport bikes. The GSX-S750 is a true apex predator.', 6, 2),
('Suzuki R600', 'r600.jpg', 'r600biker.jpg', 25679.99, 599, 'The Suzuki GSX-R600 is a class-leading sport bike worthy of its race-winning GSX-R heritage. Whether you\'re carving through your favorite twisty road or dominating the racetrack, it offers unparalleled performance.', 6, 1),
('Suzuki S1000', 's1000.jpg', 's1000biker.jpg', 29379.45, 999, 'Born on the racetrack and raised on the street, the GSX-S1000 is derived from the legendary, championship-winning GSX-R1000. The new GSX-S lineup carries the spirit of the Suzuki GSX-R to the street, with shared technology and performance packaged into a chassis designed specifically for street riding comfort.', 6, 5);


INSERT INTO `brand`(brand,logo) VALUES 
('BMW','bmw.jpg'),
('Ducati','Ducati.png'),
('Kawasaki','kawasaki.png'),
('Harley-davidson','harley-davidsoncycle.png'),
('Yamaha','yamaha.png'),
('Suzuki','suzuki.png'),
('Honda','honda.png');

INSERT INTO `style`(styleName) VALUES 
('Sport Bike'),
('Naked Bike'),
('Cruiser'),
('Touring'),
('Cafe racer');

INSERT INTO `admin` (`userName`, `password`, `fullName`, `phone`, `email`) VALUES
('Admin', '123456789', 'David Moe', '1464699991', 'moedavid@foundble.com');



