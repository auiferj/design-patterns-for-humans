### 设计模式分类

| **创建型设计模式 (Creational Design Patterns)** | **结构型设计模式 (Structural Design Patterns)** | **行为型设计模式 (Behavioral Design Patterns)** |
| :--- | :--- | :--- |
| Simple Factory | Adapter | Chain of Responsibility |
| Factory Method | Bridge | Command |
| Abstract Factory | Composite | Iterator |
| Builder | Decorator | Mediator |
| Prototype | Facade | Memento |
| Singleton | Flyweight | Observer |
| | Proxy | Visitor |
| | | Strategy |
| | | State |
| | | Template Method |

### 简单工厂
简单工厂模式只是为客户端生成一个实例，而不向客户端暴露任何实例化的逻辑。

当创建一个对象不仅仅是简单的赋值操作，而是涉及一些业务逻辑时，将其放在专门的工厂中比在每个需要的地方重复相同的代码更有意义。
1. "不仅仅是简单的赋值"
```
    // 简单赋值 - 不需要工厂
    User user = new User();
    user.setName("John");
    user.setAge(25);
```
2. "涉及一些逻辑" - 需要工厂的情况
```
    // 复杂创建逻辑 - 需要工厂
    public User createUser(String input) {
        User user = new User();
        
        // 业务逻辑1：姓名处理
        if (input.contains("@")) {
            user.setName(input.split("@")[0]);
        } else {
            user.setName(input);
        }
        
        // 业务逻辑2：年龄验证
        user.setAge(calculateAge(birthDate));
        if (user.getAge() < 18) {
            throw new IllegalArgumentException("用户必须年满18岁");
        }
        
        // 业务逻辑3：默认值设置
        user.setStatus("active");
        user.setCreatedAt(LocalDateTime.now());
        
        return user;
    }
```
3. 为什么需要工厂模式：

不好的做法（重复代码）
```
    // 在多个地方重复相同的创建逻辑
    class ServiceA {
        public void methodA() {
            User user = new User();
            // 重复的复杂逻辑...
            // 重复的复杂逻辑...
        }
    }
    
    class ServiceB {
        public void methodB() {
            User user = new User();
            // 重复的复杂逻辑...
            // 重复的复杂逻辑...
        }
    }
```

好的做法（使用工厂）
```
    // 专门的工厂类
    class UserFactory {
        public User createUser(String input) {
            // 所有创建逻辑集中在这里
            User user = new User();
            // 复杂的业务逻辑...
            return user;
        }
    }
    
    // 使用时
    class ServiceA {
        private UserFactory factory = new UserFactory();
        
        public void methodA() {
            User user = factory.createUser("input");
            // 使用user...
        }
    }
    
    class ServiceB {
        private UserFactory factory = new UserFactory();
        
        public void methodB() {
            User user = factory.createUser("input");
            // 使用user...
        }
    }
```
### 工厂方法
工厂：负责创建对象的地方。

方法：通过方法调用的方式来实现创建。

interviewer包中，是对象类，他们都有一个动作：askQuestions。意思就是每个对象都有可以问问题，但是askQuestions内部是它们各自的逻辑。

核心的类是：HiringManager。体现了"延迟创建"。

核心思想：定义一个用于创建对象的接口（工厂方法，HiringManager中的makeInterviewer），但让子类决定实例化哪一个类。工厂方法让类的实例化延迟到子类。

“方法”-它是一个方法，不是类。

如果在多个地方要创建一个对象，这个对象属于同一个类，且创建时有比较复杂的逻辑而非简单的赋值，就用简单工厂。

如果在多个地方要创建一个对象，这个对象属于不同的类，那么就用工厂方法。每新增一种产品，就新增一种工厂方法的实现。

### 抽象工厂

### 工厂方法和抽象工厂的区别
工厂方法： 关注单个产品的创建，它通过子类化来决定具体实例化哪一个产品。
抽象工厂： 关注产品家族的创建，它提供一个接口来创建一系列相关或依赖的对象，而无需指定它们的具体类。

### 简单工厂和建造者模式的对比
简单工厂

你的例子：在 Hardee's 点一个固定的套餐“Big Hardee”。

它如何工作：你告诉工厂（柜台员工）你想要什么（“一个 Big Hardee”）。工厂内部知道创建“Big Hardee”的所有细节（用什么面包、什么肉饼、什么酱料）。它根据你的指令，直接返回一个完全构建好的、不可定制的对象（汉堡）。

核心思想：“我要一个确定的东西，你直接给我就好”。创建过程是隐藏的、一步到位的。客户不关心内部细节，只关心结果。

建造者

你的例子：在 Subway 定制一个汉堡。

它如何工作：创建过程被分解成多个步骤。有一个“指导者”（Subway 员工）引导你通过一个“建造者”（Subway 的备餐流程）来一步步构建你的对象。

步骤 1：选择面包（ builder.withBread("全麦") ）

步骤 2：选择肉类（ builder.withMeat("烤鸡") ）

步骤 3：选择奶酪（ builder.withCheese("切达") ）

步骤 4：选择酱料（ builder.withSauce("西南酱") ）

...等等。

最后，当你完成所有选择后，你调用 builder.build()，最终得到你完全定制化的汉堡。

核心思想：“我想要一个按我自己的规格一步步组装的东西”。它将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表现形式。

允许你创建对象的不同“风味”（即不同变体或配置），同时避免了“构造函数污染”（这是建造者模式解决的关键问题）

“构造函数污染” 指的是：为了创建对象的各种不同变体，你不得不编写一个参数极多、极其复杂的构造函数。

例子：如果没有建造者模式，你可能需要这样一个“恐怖”的构造函数：
```
// 构造函数污染！参数太多了，难以阅读和使用。
public Computer(String cpu, String gpu, int ramSizeGB, String storageType, int storageSizeGB, boolean hasBluetooth, boolean hasWifi, String keyboardType, ...) {
    // ... 初始化代码
}
```
使用这个构造函数非常容易出错（比如把 ramSizeGB 和 storageSizeGB 的顺序传反了），而且代码可读性极差。

建造者模式通过提供一系列 setter 方法（.withCPU(), .withRAM()）来替代这个庞大的构造函数，从而“避免”了这种污染。

当一個对象可能有多种“风味”（即多种配置或表现形式）时非常有用。或者当创建一个对象需要很多步骤时（也很有用）

解释：建造者模式将复杂对象的构建过程分解成一系列清晰的步骤，使得代码不仅易于编写，更易于阅读和维护。

例子：创建一个 House 对象可能需要打地基、砌墙、安装屋顶、装修等多个步骤。建造者模式可以提供一个 Builder，里面有 .buildFoundation(), .buildWalls(), .buildRoof() 等方法，让指导者（Director）可以按顺序调用，一步步构建出房子。

---

### 设计模式对比

| 特性 | 简单工厂模式 | 建造者模式 |
| :--- | :--- | :--- |
| **过程** | 一步到位，直接返回产品 | 分步构建，逐步设置参数 |
| **产品复杂度** | 适用于创建单一、标准化的产品 | 适用于创建复杂、需要高度定制的产品 |
| **灵活性** | 低。客户无法控制创建过程的细节。 | 高。客户可以精确控制对象的各个组成部分。 |
| **类比** | 固定套餐 (Big Hardee) | 自定义套餐 (Subway) |


### 原型模式
关于浅拷贝的问题：修改拷贝得到的对象的引用类型的字段时，会把原始的对象的该字段也改掉。

比如：
```
Sheep original = new Sheep("Dolly");
original.addTrait("Friendly");

Sheep cloned = original.clone();
cloned.addTrait("Playful");

System.out.println(original.getTraits()); // 输出: [Friendly, Playful]
// 糟糕！原始对象也被修改了，因为共享同一个List对象
```
解决方案：实现深拷贝
```
@Override
public Sheep clone() {
    try {
        Sheep cloned = (Sheep) super.clone(); // 先进行浅拷贝
        // 对引用类型进行深拷贝
        cloned.traits = new ArrayList<>(this.traits); // 创建新的ArrayList
        return cloned;
    } catch (CloneNotSupportedException e) {
        throw new AssertionError();
    }
}
```
原型模式的要求：

1. 必须实现 Cloneable 接口
2. 必须重写并公开 clone() 方法

浅拷贝：只复制引用，不复制引用指向的对象。简单来说，浅拷贝就是“只复制一层”。

对于基本类型，修改拷贝对象属性值，不会影响原始对象属性值。

对于引用类型，修改拷贝对象的属性值，不会复制一个新的，而是会复制该属性的引用地址。

浅拷贝：只复制对象的顶层。如果顶层属性是基本类型，则直接复制值；如果是引用类型，则只复制内存地址。

深拷贝：不仅复制对象本身，还会递归地复制所有引用类型的属性，直到所有对象都被复制到新的内存地址。这样，新旧对象之间完全独立，互不影响。

这个模型的使用：

创建现有对象的副本不是最终目标，而是一个起点。你可以再福报基础上进行定制化修改，得到你想要的具体对象。而不是经历从头创建对象并进行设置的麻烦。

这是这个模式要解决的痛点---避免重复、繁琐的初始化过程。

为什么这个麻烦值得避免？
1. 复杂的初始化过程
```
// "从头创建的麻烦"示例
public class ComplexObject {
    public ComplexObject() {
        loadConfigFromFile();    // 耗时操作
        initializeDatabase();    // 复杂初始化
        setupNetworkConnection();// 可能失败的操作
        loadUserPreferences();   // 需要外部资源
        // ... 更多繁琐设置
    }
}

// 使用原型模式避免麻烦
ComplexObject prototype = new ComplexObject(); // 只做一次麻烦的初始化
ComplexObject newInstance = prototype.clone(); // 后续都通过克隆
```
2. 多重参数配置
```
// 传统的麻烦方式
GameCharacter warrior = new GameCharacter(
    "Warrior",           // 类型
    100,                 // 生命值
    50,                  // 攻击力
    30,                  // 防御力
    heavyArmor,          // 装备
    aggressiveAI,        // AI行为
    warriorAppearance    // 外观
);

// 原型模式的简便方式
GameCharacter warriorTemplate = new GameCharacter(...); // 一次性配置
GameCharacter warrior1 = warriorTemplate.clone();
GameCharacter warrior2 = warriorTemplate.clone();
```
3. 真实世界比喻
比喻1：文档模板

从头创建：手动设置页边距、字体、页眉页脚、样式...

原型模式：打开一个模板文档 → 修改内容 → 完成

比喻2：烹饪

从头创建：买食材、准备调料、按步骤烹饪

原型模式：有一碗做好的汤 → 加点盐/胡椒 → 完成

比喻3：汽车制造

从头创建：制造每个零件、组装、测试

原型模式：有一辆现车 → 换个颜色/加个配件 → 完成
4. 代码
游戏开发场景
```
// 麻烦的传统方式
public class Monster {
    private String type;
    private int health;
    private int damage;
    private Behavior behavior;
    private Appearance appearance;
    
    public Monster(String type) {
        this.type = type;
        this.health = loadHealthFromConfig(type);    // 麻烦的配置加载
        this.damage = loadDamageFromConfig(type);
        this.behavior = createBehavior(type);        // 复杂的对象创建
        this.appearance = loadAppearance(type);      // 耗时的资源加载
    }
}

// 使用原型模式的简便方式
Monster dragonTemplate = new Monster("Dragon"); // 只做一次麻烦的初始化

// 需要新怪物时直接克隆
Monster dragon1 = dragonTemplate.clone();
Monster dragon2 = dragonTemplate.clone();
dragon2.setHealth(150); // 按需微调

Monster orcTemplate = new Monster("Orc"); // 另一个原型
Monster orc1 = orcTemplate.clone();
```
游戏开发 - 创建大量相似敌人
```
// 原型：一个配置好的敌人模板
Enemy dragonTemplate = new Enemy("Dragon", 1000, 50);
dragonTemplate.setBehavior(aggressiveBehavior);
dragonTemplate.setAppearance(dragonAppearance);

// 通过克隆创建多个相同类型的敌人
List<Enemy> dragonArmy = new ArrayList<>();
for (int i = 0; i < 50; i++) {
    Enemy dragon = dragonTemplate.clone(); // 快速创建
    dragon.setPosition(randomPosition());  // 微调个性化设置
    dragonArmy.add(dragon);
}
```
文档处理 - 模板文档
```
// 创建文档模板
Document invoiceTemplate = new Document();
invoiceTemplate.setHeader("公司发票模板");
invoiceTemplate.setFooter("谢谢惠顾");
invoiceTemplate.addStyle(corporateStyle);

// 为每个客户克隆并定制
Document customerInvoice = invoiceTemplate.clone();
customerInvoice.setCustomerName("张三");
customerInvoice.setAmount(5000);
```

5. 原型模式的适用场景
当对象创建成本高昂时（数据库连接、网络请求、文件IO）

当需要创建大量相似对象时（游戏中的NPC、图形界面元素）

当系统需要独立于如何创建、组合和表示对象时

当需要避免构建与产品类层次平行的工厂类层次时

6. 总结

它承认很多时候我们不需要从零开始创造，而是在现有成果的基础上进行适当的修改和定制。这种模式：

✅ 节省资源：避免重复的昂贵初始化

✅ 提高性能：克隆通常比新建更快

✅ 保持灵活：可以在运行时动态创建对象

✅ 简化代码：避免复杂的构造函数和配置逻辑

正是这种"站在巨人的肩膀上"的思维，让原型模式成为处理复杂对象创建场景的强大工具。

### 单例模式
现实世界的例子：

一个国家只能有一位总统。无论何时，只要职责需要，就必须由同一位总统来执行任务。这里的总统是独一无二。

---

### 单例模式的总统比喻

| **现实世界** | **编程世界** | **单例模式原则** |
| :--- | :--- | :--- |
| 一个国家只能有一个总统 | 一个类只能有一个实例 | 唯一性 |
| 无论何时需要总统，都是同一个总统 | 无论何时请求实例，都返回同一个实例 | 全局访问点 |
| 总统是随时待命、可用的 | 实例在需要时就已经存在或可创建 | 按需创建 |
---

为什么说这是单例模式？

单例模式的核心目标是确保一个类在整个应用程序生命周期中只有一个实例，并提供一个全局访问点。

使用枚举（Enum）来实现单例，完美地满足了这两个要求：

保证实例唯一性：

Java 语言规范规定，枚举常量是天然的单例。当你定义一个枚举类型时，JVM 会保证其中的每个枚举常量在类加载时只会创建一次。

你定义的 INSTANCE 就是这个唯一的枚举常量，因此它就是唯一的 President 实例。

提供全局访问点：

你可以通过 President.INSTANCE 随时随地访问这个唯一的实例，这正是单例模式所要求的。

为什么用枚举实现单例是最佳实践？
与传统的“饿汉式”或“懒汉式”单例实现相比，使用枚举有以下几个显著优点：

线程安全：枚举的实例创建是由 JVM 保证的，是天生线程安全的。你不需要像在其他实现中那样去手动处理同步（synchronized）问题。

防止反射攻击：传统的单例模式可以通过 Java 反射机制来创建多个实例，从而破坏单例。而枚举没有公共构造函数，因此反射无法创建新的实例。

防止反序列化攻击：如果你序列化一个单例对象，然后再反序列化回来，可能会得到一个新的实例。而枚举的序列化和反序列化由 JVM 负责，它会确保反序列化后得到的仍然是同一个实例。

总结来说，使用枚举来实现单例模式，代码简洁、安全且健壮，能够有效避免传统实现中可能遇到的所有问题，因此被认为是 Java 中实现单例模式的最佳方式。




