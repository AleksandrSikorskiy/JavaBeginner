package org.example;

/**
 * Hello world!
 */


class Lifebio {
    //   Характеристика био жизни
    boolean blife = true; //признак жизни
    int typo;  // класс
    String typoname; // подкласс
    int drink = 1;  // необходимо воды для жизни
    int perdrink;  // период питания
    int kolproductionair; // производит кислорода
    int perproductionair; // период (цикл) производства кислорода
    int kolproductioneat; // производит еды
    int perproductioneat; // период (цикл) производства еды
    int perpopulation; // период размножения
    int plusPopulation; // производство себе подобных за период
    int population; // количество (популяция)
    int permutation; // периодичность мутации
}

class Lifejivo {
    //   Характеристика животной жизни
    boolean blife; //признак жизни
    int typo;  // класс
    String typoname; // подкласс
    String name; // личное имя животного(человека)
    int drink;  // необходимо воды для жизни
    int eat; // необходимо еды для жизни
    int air; // необходимо воздуха для жизни
    int perdrink;  // период питья
    int pereat;  // период питания
    int perair;  // период дыхания
    int perpopulation; // период размножения
    int plusPopulation; // производство себе подобных за период
    int population; // количество (популяция)
    int permutation; // периодичность мутаций

}

class Generationname {
    String[] lits = {"а", "е", "ё", "и", "й", "о", "у", "ы", "э", "ю", "я"};
    String[] litg = {"б", "в", "г", "д", "ж", "з", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х", "ц", "ч", "ш", "щ"};
    String[] arrgenname = {"gsggs", "sggs", "gsgsgsgs", "ggsgsg", "gsgss", "sgs", "gsggssg", "ggsgg", "sgsg", "gsgss", "sgsgsgggs", "gssgsg", "gsggs", "gsgs", "gsgg", "gsgsg"};

    String newname() {
        int rand = (int) (Math.random() * (arrgenname.length));
        String sss = arrgenname[rand];
        int isss = sss.length();
        int is = 0;
        int ig = 0;
        int i = 0;
        String sname = "";
        for (i = 0; i < isss; i++) {
            is = (int) (Math.random() * (lits.length));
            ig = (int) (Math.random() * (litg.length));
            String si = sss.substring(i, i + 1);
            if (si.equals("g")) {
                sname = sname + litg[ig];
            }
            if (si.equals("s")) {
                sname = sname + lits[is];
            }
            if (i == 0) {
                sname = sname.toUpperCase();
            }
        }
        return sname;
    }
}

class Cataclizm {
    String[] catname = {"Сильный ветер поднял марсианскую пыль",
            "Летнее марсианское Солнце сильно нагрело поверхность",
            "Начал извержение самый большой Вулкан в Солнечной системе Олимп ",
            "Под резевацией колонии произошло землетрясение",
            "Одичавшие животные напали на незащищенную колонию",
            "Небо развеглось, земля содрогнулась и неожиданно ударили несколько молний",
            "Несколько туч объединились в одну и с неба посыпался сильный Град",
            "Неожиданно из под земли начала просачиватся талая холодная вода",
            "Невероятный оползень скатился с ближайшей горы",
            "С неба на землю спустилась тонкая завихрённая струя воздуха, и начался Ураган"};
    String[] catres = {"be", "bv", "beva", "bev", "be", "be", "b", "be", "bev", "be"};

    String go() {
        int ic = (int) (Math.random() * catname.length);
        if (catres[ic].contains("v")) {
            res.voda = res.voda - ((int) (Math.random() * 100 + 20));
        }
        if (catres[ic].contains("e")) {
        }
        if (catres[ic].contains("a")) {
        }
        return catname[ic];
    }
}

class LifeonMars {
    public static void main(String[] args) {
        Res res = new Res();
        res.go();
        String[] randtypo = {"Гриб", "Растение", "Трава", "Сорняк", "Кустарник", "Дерево", "Животное", "Рептилия", "Человек"};
        String[] randgrib = {"Рыжик", "Белый", "Маслюк", "Груздь", "Мухомор"};
        String[] randrast = {"Картошка", "Капуста", "Лук", "Чеснок", "Пшеница", "Рис", "Щавель", "Томат", "Огурец", "Тыква", "Кабачок", "Петрушка", "Кинза", "Буряк", "Горох", "Фасоль"};
        String[] randtrava = {"Зверобой", "Лаванда", "Мята", "Шалфей", "Материнка"};
        String[] randsor = {"Одуванчик", "Пырей", "Лебеда", "Горчица", "Ромашка", "Василёк"};
        String[] randkust = {"Смородина", "Крыжовник", "Рябина", "Малина", "Ежевика"};
        String[] randtree = {"Вишня", "Орех", "Яблоня", "Персик", "Груша", "Абрикос", "Черешня", "Слива", "Алыча", "Шелковица", "Айва"};
        String[] randjivo = {"Обезьяна", "Собака", "Кот", "Мышь", "Корова", "Овца", "Свинья", "Петух", "Курица", "Рыба"};
        String[] randrept = {"Ящерица", "Черепаха", "Варан", "Крокодил", "Змея", "Уж", "Геккон"};
        String[] randpeople = {"Европеец", "Русотуристо", "ДревнийУкр", "Америкос", "Кореец", "Китаец", "Индиец", "Африканец"};
        int irandtypo = randtypo.length;
        int igrib = randgrib.length;
        int irast = randrast.length;
        int itrava = randtrava.length;
        int isor = randsor.length;
        int ikust = randkust.length;
        int itree = randtree.length;
        int ijivo = randjivo.length;
        int irept = randrept.length;
        int ipeople = randpeople.length;
        Res res = new Res();
//        Генерация грибов
        Lifebio[] agrib = new Lifebio[igrib];
        for (int i = 0; i < igrib; i++) {
            agrib[i] = new Lifebio();
            agrib[i].blife = true;
            agrib[i].typo = 0;
            agrib[i].typoname = randgrib[i];
            agrib[i].drink = 1;
            agrib[i].perdrink = 14;
            agrib[i].kolproductionair = 1;
            agrib[i].perproductionair = 3;
            agrib[i].kolproductioneat = 1;
            agrib[i].perproductioneat = 5;
            agrib[i].perpopulation = 60;
            agrib[i].plusPopulation = 1000;
            agrib[i].population = (int) (Math.random() * 10000 + 10);
            agrib[i].permutation = 60000;
        }
        //        Генерация растений
        Lifebio[] arast = new Lifebio[irast];
        for (int i = 0; i < irast; i++) {
            arast[i] = new Lifebio();
            arast[i].blife = true;
            arast[i].typo = 1;
            arast[i].typoname = randrast[i];
            arast[i].drink = 1;
            arast[i].perdrink = 7;
            arast[i].kolproductionair = 3;
            arast[i].perproductionair = 1;
            arast[i].kolproductioneat = 8;
            arast[i].perproductioneat = 60;
            arast[i].perpopulation = 20;
            arast[i].plusPopulation = 100;
            arast[i].population = (int) (Math.random() * 1000 + 10);
            arast[i].permutation = 7000;
        }
        //        Генерация травы
        Lifebio[] atrava = new Lifebio[itrava];
        for (int i = 0; i < itrava; i++) {
            atrava[i] = new Lifebio();
            atrava[i].blife = true;
            atrava[i].typo = 2;
            atrava[i].typoname = randtrava[i];
            atrava[i].drink = 1;
            atrava[i].perdrink = 90;
            atrava[i].kolproductionair = 1;
            atrava[i].perproductionair = 3;
            atrava[i].kolproductioneat = 1;
            atrava[i].perproductioneat = 30;
            atrava[i].perpopulation = 360;
            atrava[i].plusPopulation = 3;
            atrava[i].population = (int) (Math.random() * 10000 + 10);
            atrava[i].permutation = 70000;
        }
        //        Генерация сорняков
        Lifebio[] asor = new Lifebio[isor];
        for (int i = 0; i < isor; i++) {
            asor[i] = new Lifebio();
            asor[i].blife = true;
            asor[i].typo = 3;
            asor[i].typoname = randsor[i];
            asor[i].drink = 2;
            asor[i].perdrink = 30;
            asor[i].kolproductionair = 0;
            asor[i].perproductionair = 0;
            asor[i].kolproductioneat = 0;
            asor[i].perproductioneat = 0;
            asor[i].perpopulation = 60;
            asor[i].plusPopulation = 100;
            asor[i].population = (int) (Math.random() * 50 + 10);
            asor[i].permutation = 30000;
        }
        //        Генерация кустарника
        Lifebio[] akust = new Lifebio[ikust];
        for (int i = 0; i < ikust; i++) {
            akust[i] = new Lifebio();
            akust[i].blife = true;
            akust[i].typo = 4;
            akust[i].typoname = randkust[i];
            akust[i].drink = 4;
            akust[i].perdrink = 25;
            akust[i].kolproductionair = 5;
            akust[i].perproductionair = 1;
            akust[i].kolproductioneat = 20;
            akust[i].perproductioneat = 5;
            akust[i].perpopulation = 360;
            akust[i].plusPopulation = 4;
            akust[i].population = (int) (Math.random() * 500 + 10);
            akust[i].permutation = 10000;
        }
        //        Генерация деревьев
        Lifebio[] atree = new Lifebio[itree];
        for (int i = 0; i < itree; i++) {
            atree[i] = new Lifebio();
            atree[i].blife = true;
            atree[i].typo = 5;
            atree[i].typoname = randtree[i];
            atree[i].drink = 10;
            atree[i].perdrink = 90;
            atree[i].kolproductionair = 50;
            atree[i].perproductionair = 1;
            atree[i].kolproductioneat = 200;
            atree[i].perproductioneat = 360;
            atree[i].perpopulation = 360;
            atree[i].plusPopulation = 3;
            atree[i].population = (int) (Math.random() * 80 + 5);
            atree[i].permutation = 900;
        }
        //        Генерация животных
        Lifejivo[] ajivo = new Lifejivo[ijivo];
        for (int i = 0; i < ijivo; i++) {

            ajivo[i] = new Lifejivo();
            ajivo[i].blife = true;
            ajivo[i].typo = 6;
            ajivo[i].typoname = randjivo[i];
            ajivo[i].drink = 3;
            ajivo[i].eat = 1;
            ajivo[i].air = 300;
            ajivo[i].perdrink = 1;
            ajivo[i].pereat = 1;
            ajivo[i].perair = 1;
            ajivo[i].perpopulation = 720;
            ajivo[i].plusPopulation = 1;
            ajivo[i].population = (int) (Math.random() * 1000 + 50);
            ajivo[i].permutation = 7200000;
        }
        //        Генерация рептилий
        Lifejivo[] arept = new Lifejivo[irept];
        for (int i = 0; i < irept; i++) {

            arept[i] = new Lifejivo();
            arept[i].blife = true;
            arept[i].typo = 7;
            arept[i].typoname = randrept[i];
            arept[i].drink = 5;
            arept[i].eat = 3;
            arept[i].air = 100;
            arept[i].perdrink = 5;
            arept[i].pereat = 3;
            arept[i].perair = 1;
            arept[i].perpopulation = 360;
            arept[i].plusPopulation = 5;
            arept[i].population = (int) (Math.random() * 25 + 2);
            arept[i].permutation = 25000000;
        }
        //        Генерация гуманоидов
        Lifejivo[] apeople = new Lifejivo[res.kpeople];
        Generationname genname = new Generationname();

        for (int i = 0; i < res.kpeople; i++) {

            apeople[i] = new Lifejivo();
            apeople[i].blife = true;
            apeople[i].typo = 8;
            int k = (int) (Math.random() * ipeople);
            apeople[i].typoname = randpeople[k];
            apeople[i].name = genname.newname();
            apeople[i].drink = 3;
            apeople[i].eat = 3;
            apeople[i].air = 1000;
            apeople[i].perdrink = 1;
            apeople[i].pereat = 1;
            apeople[i].perair = 1;
            apeople[i].perpopulation = 720;
            apeople[i].plusPopulation = 1;
            apeople[i].population = 1;
            apeople[i].permutation = 10000000;
        }

        System.out.println("После долгого и опасного путешествия с Земли на планету Марс наконец-то прилетели колонисты!");
        System.out.println("И теперь жизнь начинает распространятся и адаптироватся к новым условиям.");
        System.out.println("По исходным данным жизнь разложена на 9 уровней.");
        System.out.println("Жизнь высшего уровня может питаться низшими при недостатке еды или воды.");
        System.out.println("Гриб<Растение<Трава<Сорняк<Кустарник<Дерево<Животное<Рептилия<Человек");
        System.out.println("Жизни с уровнем 1..6 Гриб Растение Трава Сорняк Кустарник Дерево достаточно только воды для размножения.");
        System.out.println("После примарсения часть груза было утеряно осталось " + voda + " воды , " + eda + " еды.");
        System.out.println("Но не всё так плохо в атмосфере оказалось " + air + " запасов воздуха пригодного для дыхания.");
        System.out.println("Воздух стал доступен после предварительного терраформирования планеты грибами, компьютер оценил запасы оставшихся спор грибов в районе посадки.");
        int i = 0;
        for (i = 0; i < igrib; i++) {
            System.out.println(randtypo[0] + " " + agrib[i].typoname + " = " + agrib[i].population + " спор");
        }
        System.out.println(kpeople + " колонистов в срочном порядке провели пересчет всех оставшихся ресурсов:");

        i = 0;
        for (i = 0; i < irast; i++) {
            System.out.println(randtypo[1] + " " + arast[i].typoname + " = " + arast[i].population + " штук");
        }
        System.out.println("При переучете обнаружены семена травяных растений которые не планировались для транспортирования.");
        i = 0;
        for (i = 0; i < itrava; i++) {
            System.out.println(randtypo[2] + " " + atrava[i].typoname + " = " + atrava[i].population + " семян");
        }
        System.out.println("Чёрт,чёрт чёрт ! Воскликнул колонист сканеры обнаружили семена сорных растений среди продуктивных семян, произвели их подсчет и поняли что отделить их невозможно.");
        i = 0;
        for (i = 0; i < isor; i++) {
            System.out.println(randtypo[3] + " " + asor[i].typoname + " = " + asor[i].population + " семян");
        }
        System.out.println("Колонисты добрались до огромных контейнеров и обнаружили саженцы кустов и деревьев.");
        i = 0;
        for (i = 0; i < ikust; i++) {
            System.out.println(randtypo[4] + " " + akust[i].typoname + " = " + akust[i].population + " единиц");
        }
        i = 0;
        for (i = 0; i < itree; i++) {
            System.out.println(randtypo[5] + " " + atree[i].typoname + " = " + atree[i].population + " единиц");
        }
        System.out.println("Колонисты запустили процесс воссоздания ткани по чтению ДНК животных.");
        System.out.println("Удалось воссоздать животных, среди которых оказались не только домашние:");
        i = 0;
        for (i = 0; i < ijivo; i++) {
            System.out.println(randtypo[6] + " " + ajivo[i].typoname + " = " + ajivo[i].population + " единиц");
        }
        System.out.println("Как оказалось среди животных каким-то образом оказались и ДНК рептилий:");
        i = 0;
        for (i = 0; i < irept; i++) {
            System.out.println(randtypo[7] + " " + arept[i].typoname + " = " + arept[i].population + " единиц");
        }
        System.out.println("Рептилии в неволе взбунтовались и пробили брешь в искуственной резервации.");
        System.out.println("Вместе с рептилиями сбежали и все животные.");
        System.out.println("Колонисты решили отлавливать полезных животных по мере необходимости.");
        System.out.println("Соло: 1");
        System.out.println("Колонисты собрались вместе и перезнакомились:");
        i = 0;
        for (i = 0; i < res.kpeople; i++) {
            System.out.println(randtypo[8] + " " + apeople[i].typoname + " " + apeople[i].name);
        }
        System.out.println("Во время пересчета произошло случайное событие:");
        int nsol = 2;
        int lifekol = 20;

        while (lifekol > 0) {
            System.out.println("Соло: " + nsol);
            lifekol = lifekol - 1;
            nsol = nsol + 1;
            System.out.println(res.eda + " " + res.voda + " " + res.air);
        }
    }
}

