package org.example;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

// генерация random в диапазоне min..max

class Random {
    static int randomize(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}

class NameClass {

    private String[][] nameclass={{"Гриб","Рыжик", "Белый", "Маслюк", "Груздь", "Мухомор"},
            {"Растение","Картошка", "Капуста", "Лук", "Чеснок", "Пшеница", "Рис", "Щавель", "Томат", "Огурец", "Тыква", "Кабачок", "Петрушка", "Кинза", "Буряк", "Горох", "Фасоль"},
            {"Трава","Зверобой", "Лаванда", "Мята", "Шалфей", "Материнка"},
            {"Сорняк","Одуванчик", "Пырей", "Лебеда", "Горчица", "Ромашка", "Василёк"},
            {"Кустарник","Смородина", "Крыжовник", "Рябина", "Малина", "Ежевика"},
            {"Дерево","Вишня", "Орех", "Яблоня", "Персик", "Груша", "Абрикос", "Черешня", "Слива", "Алыча", "Шелковица", "Айва"},
            {"Животное","Обезьяна", "Собака", "Кот", "Мышь", "Корова", "Овца", "Свинья", "Петух", "Курица", "Рыба"},
            {"Рептилия","Ящерица", "Черепаха", "Варан", "Крокодил", "Змея", "Уж", "Геккон"},
            {"Человек","Европеец", "Русотуристо", "ДревнийУкр", "Америкос", "Кореец", "Китаец", "Индиец", "Африканец"}};

    public int lengthnameclass= nameclass.length;

    public String getname(int iclass,int ipodclass){
        String sname="Класс не определён";
        if ((iclass>=0)&&(iclass<=lengthnameclass)) {
            if ((ipodclass>=0)&&(ipodclass<=nameclass[iclass].length)) {
                sname = nameclass[iclass][ipodclass];
            }

        }
        return sname;
    }
    public int getlenclass() {
        return nameclass.length;
    }
    public int getlenpodclass(int iclass) {
        return nameclass[iclass].length;
    }
}

class BioLife {
    //   Характеристика био жизни
    boolean enable; //признак жизни
    int codeclass;  // класс
    int codepodclass; // подкласс
    int drink;  // необходимо воды для жизни
    int eat; // необходимо еды для жизни
    int air; // необходимо воздуха для жизни
    int proddrink; // производит воды
    int prodeat; // производит еды
    int prodair; // производит воздуха
    int perpopulation; // период размножения
    int addpopulation; // производство себе подобных за период
    int population=1; // количество (популяция) по умолчанию 1
    int permutation; // периодичность мутации
}

class Resources {
    private int air;
    private int eat;
    private int drink;

    public void generation() {

    }
    public void setair (int iair){
        air=iair;
    }
    public void seteat (int ieat){
        eat=ieat;
    }
    public void setdrink (int idrink){
        drink=idrink;
    }
    public int getair (){
        return air;
    }
    public int geteat (){
        return eat;
    }
    public int getdrink (){
        return drink;
    }


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
    int air;
    int eat;
    int drink;
    int population;

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
        String sinfo=" уничтожено ";
        int ic = (int) (Math.random() * catname.length);
        if (catres[ic].contains("v")) {
            drink= ((int) (Math.random() * 100 + 20));
            sinfo=sinfo+drink+" воды ";
        }
        if (catres[ic].contains("e")) {
            eat= ((int) (Math.random() * 100 + 20));
            sinfo=sinfo+eat+" еды ";
        }
        if (catres[ic].contains("a"))
        {
            air= ((int) (Math.random() * 1000 + 20));
            sinfo=sinfo+air+" воздуха ";
        }
        if (catres[ic].contains("b"))
        {
            population= ((int) (Math.random() * 10 + 1));
            sinfo=sinfo+population+" популяции ";
        }
        return catname[ic]+" "+sinfo+".";
    }

    public void setair (int iair){
        air=iair;
    }
    public void seteat (int ieat){
        eat=ieat;
    }
    public void setdrink (int idrink){
        drink=idrink;
    }
    public int getair (){
        return air;
    }
    public int geteat (){
        return eat;
    }
    public int getdrink (){
        return drink;
    }

}

class LifeonMars {
    public static void main(String[] args) {
        Resources res = new Resources();
        NameClass ncl = new NameClass();
//        ArrayList<BioLife> arrbio=new ArrayList();
//        Генерация классов и подклассов
        BioLife[] arrbio = new BioLife[];
        for (int i = 0; i < ncl.getlenclass(); i++) {
            for (int j = 0; j<ncl.getlenpodclass(i); j++) {
                arrbio.
                agrib[i] = new BioLife();
                agrib[i].enable = true;
                agrib[i].codeclass = 0;
                agrib[i].nameclass = randgrib[i];
                agrib[i].drinkwater = 1;
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
            System.out.println(randtypo[0] + " " + agrib[i].nameclass + " = " + agrib[i].population + " спор");
        }
        System.out.println(kpeople + " колонистов в срочном порядке провели пересчет всех оставшихся ресурсов:");

        i = 0;
        for (i = 0; i < irast; i++) {
            System.out.println(randtypo[1] + " " + arast[i].nameclass + " = " + arast[i].population + " штук");
        }
        System.out.println("При переучете обнаружены семена травяных растений которые не планировались для транспортирования.");
        i = 0;
        for (i = 0; i < itrava; i++) {
            System.out.println(randtypo[2] + " " + atrava[i].nameclass + " = " + atrava[i].population + " семян");
        }
        System.out.println("Чёрт,чёрт чёрт ! Воскликнул колонист сканеры обнаружили семена сорных растений среди продуктивных семян, произвели их подсчет и поняли что отделить их невозможно.");
        i = 0;
        for (i = 0; i < isor; i++) {
            System.out.println(randtypo[3] + " " + asor[i].nameclass + " = " + asor[i].population + " семян");
        }
        System.out.println("Колонисты добрались до огромных контейнеров и обнаружили саженцы кустов и деревьев.");
        i = 0;
        for (i = 0; i < ikust; i++) {
            System.out.println(randtypo[4] + " " + akust[i].nameclass + " = " + akust[i].population + " единиц");
        }
        i = 0;
        for (i = 0; i < itree; i++) {
            System.out.println(randtypo[5] + " " + atree[i].nameclass + " = " + atree[i].population + " единиц");
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
        System.out.println("Во время пересчета произошло случайное событие:");Cataclizm.go;
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

