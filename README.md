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

### 桥接模式
桥接模式的核心：将网页抽象（WebPage）与主题实现（Theme）分离，让它们可以独立变化。

使用场景：桥接模式在实际开发中主要用于解决多个维度变化的组合爆炸问题。

两个维度都需要独立扩展（如：形状×颜色）

避免永久性的绑定（需要在运行时切换实现）

抽象和实现都需要通过继承扩展

存在多个变化维度，且维度会组合爆炸

实际案例参考：

Spring框架中的JDBC抽象

抽象部分：JdbcTemplate（统一的操作接口）

实现部分：各种数据库驱动（MySQL、Oracle、PostgreSQL等）

1. 多维度独立变化的场景

🔧 典型场景：图形绘制系统
```
// 抽象部分：形状
abstract class Shape {
protected Color color;  // 桥接的颜色维度

public Shape(Color color) {
this.color = color;
}

abstract void draw();
}

// 实现部分：颜色
interface Color {
void applyColor();
}

// 组合使用
Shape redCircle = new Circle(new RedColor());
Shape blueRectangle = new Rectangle(new BlueColor());
```
分析：Shape（抽象）和 Color（实现）是两个独立的维度，可以自由组合。增加新的形状或颜色都非常容易，无需修改现有代码。

实际应用：UI组件库（按钮、输入框等）需要支持多种样式主题

2. 平台无关性抽象

🔧 典型场景：跨平台开发
```
// 抽象部分：应用功能
interface Notification {
void send(String message);
}

// 实现部分：平台具体实现
interface NotificationPlatform {
void deliver(String message);
}

class IOSNotification implements Notification {
private NotificationPlatform platform;
// 桥接到iOS具体实现
}

class AndroidNotification implements Notification {
private NotificationPlatform platform;
// 桥接到Android具体实现
}
```

实际应用：React Native、Flutter等跨平台框架的底层架构

3. 数据库访问层设计

🔧 典型场景：多数据库支持
```
// 抽象部分：数据访问接口
interface UserRepository {
User findById(Long id);
void save(User user);
}

// 实现部分：数据库驱动
interface DatabaseDriver {
Connection getConnection();
void execute(String sql);
}

class MySQLUserRepository implements UserRepository {
private MySQLDriver driver;  // 桥接到MySQL
}

class PostgreSQLUserRepository implements UserRepository {
private PostgreSQLDriver driver;  // 桥接到PostgreSQL
}
```
4. 消息通知系统

🔧 典型场景：多通道消息推送
```
// 消息类型维度
interface Message {
String getContent();
}

// 发送通道维度  
interface MessageChannel {
void send(Message message);
}

// 灵活组合
Message alert = new AlertMessage();
MessageChannel smsChannel = new SMSChannel();
MessageChannel emailChannel = new EmailChannel();

// 同一消息通过不同通道发送
smsChannel.send(alert);
emailChannel.send(alert);
```
桥接模式中的“抽象”和“实现”不能简单地等同于我们平时说的“抽象类”和“具体实现类”。

### 核心理解：从生活例子出发

想象一下你家的**电灯开关**和**电灯**本身：

*   **开关（抽象）：** 它定义了你要“做什么”——即“开”和“关”这个操作。这是一个**抽象的行为**。
*   **电灯（实现）：** 它定义了“怎么做”——即当你按下“开”时，电流如何通过灯丝或LED芯片发光。这是一个**具体的实现**。

**关键点在于：** 同一个开关（比如一个标准的墙上的翘板开关），可以控制不同“实现”的灯：普通的白炽灯、节能灯、智能彩灯，甚至可以是电风扇！开关的“抽象”（开/关动作）和电灯的“实现”（如何亮/如何转）是**完全独立**的，它们通过电线“桥接”在一起。

---

### 官方定义中的“抽象”与“实现”

在桥接模式中，这两个词有更特定的含义：

#### 1. 抽象化角色

*   **它代表的是“做什么”的维度。** 它定义了一个高层控制逻辑的接口或抽象类。
*   **它不自己完成具体工作，而是包含一个对“实现化”对象的引用。**
*   **它会将客户端的请求委派给“实现化”对象来完成。**
*   **这个维度可以独立扩展。** 比如，除了基本的“开/关”抽象，我可以扩展出一个“调光开关”的抽象，它增加了“调节亮度”的操作，但它底层依然可以委派给任何类型的灯去实现“亮度调节”。

**典型例子：**
*   **遥控器（抽象）：** 它有开机、关机、换台、调音量等抽象操作。
*   **图形窗口（抽象）：** 它有最大化、最小化、关闭等抽象操作。
*   **支付网关（抽象）：** 它有支付、退款、查询等抽象操作。

#### 2. 实现化角色

*   **它代表的是“怎么做”的维度。** 它提供了真正执行操作的底层接口。
*   **它只关心最核心的功能实现，不关心高层的业务逻辑。**
*   **这个接口比“抽象化”接口更加基本和底层。**
*   **这个维度也可以独立扩展。** 比如，我可以为“灯”这个实现化接口增加“智能语音灯”的实现，它支持用语音控制颜色，但它的“开”和“关”依然可以被最基础的开关控制。

**典型例子：**
*   **电视机（实现）：** 它具体执行开机、显示画面、播放声音等。不同的电视机（索尼、三星）实现方式不同。
*   **操作系统GUI API（实现）：** 它提供了在屏幕上绘制窗口、按钮的原生函数。Windows、macOS、Linux的实现各不相同。
*   **支付渠道（实现）：** 它具体执行与银行、支付宝、微信的通信协议。每个渠道的实现逻辑都不同。

### 最重要的区别：维度

**为什么不用继承？**

如果不用桥接模式，我们会这样设计：
`RedCircle`, `BlueCircle`, `RedSquare`, `BlueSquare`...

这样做的问题是：**抽象（形状）和实现（颜色）两个维度耦合在了一起**。如果现在要加一个“黄色”，或者加一个“三角形”，类的数量会呈乘法增长（M种形状 x N种颜色）。

**桥接模式通过组合将这两个维度解耦：**
- **抽象维度（形状）**：`Shape` -> `Circle`, `Square`... （一条继承链）
- **实现维度（颜色）**：`Color` -> `Red`, `Blue`... （另一条独立的继承链）

两个维度通过`Shape`类中的`Color color`引用**桥接**在一起，可以独立变化，自由组合。

### 总结

在桥接模式中：

| 术语 | 真实含义 | 关注点 | 例子 |
| :--- | :--- | :--- | :--- |
| **抽象** | **控制层、业务逻辑层、接口层** | **做什么** | 遥控器、图形窗口、支付网关、形状 |
| **实现** | **平台层、底层实现、核心功能层** | **怎么做** | 电视机、操作系统API、支付渠道、颜色 |

**核心思想就是：不要建立一个固定的、庞杂的继承体系，而是识别出系统中哪些是抽象维度，哪些是实现维度，然后用“搭桥”（组合）的方式将它们连接起来，从而获得更大的灵活性。*

### 组合模式

---
想象一个公司的组织结构：

- company
    - **技术部门**
        - **后端组**
            - 程序员A
            - 程序员B
        - **前端组**
            - 前端工程师A
    - **销售部门**
        - 销售员A
        - 销售员B 

关键洞察：无论是单个员工还是一个部门，你都可以：

计算总薪资

分配工作任务

评估绩效

组合模式的核心思想：让客户端用统一的方式处理单个对象和对象组合
也就是说，无论你面对的是：

🧍 叶子节点（单个员工）

👥 组合节点（部门、团队）

你都可以用同样的方法来操作。

```
文件夹: 根目录
  文件: 文档1.txt
  文件: 图片.png
  文件夹: 子文件夹
    文件: 秘密文件.pdf
```
分析：Directory（组合）和 File（叶子）都实现了 FileSystemComponent 接口。客户端可以一致地对待单个文件和整个文件夹树，无需关心处理的是哪个具体类型。
### 设计模式对比
桥接模式和组合模式在结构上有些相似（都使用了组合/聚合关系），但它们的意图和解决的问题完全不同。

简单来说：

桥接模式： 核心是解耦抽象（做什么）和实现（怎么做），让它们可以独立变化。它处理的是两个不同维度的层次结构。

组合模式： 核心是统一处理单个对象和组合对象，构建一个树形结构来表示“部分-整体”的层次关系。它处理的是同一个维度的层次结构。
下面我们从多个维度进行详细对比。

---

### 对比表格

| 维度 | 桥接模式 | 组合模式 |
| :--- | :--- | :--- |
| **意图** | 将抽象部分与其实现部分分离，使它们都可以独立地变化。 | 将对象组合成树形结构以表示“部分-整体”的层次结构。使得用户对单个对象和组合对象的使用具有一致性。 |
| **解决的问题** | **多维度的变化**。当一个类存在多个变化的维度（如抽象维度、实现维度），使用继承会导致类爆炸（如M x N个类）。 | **树形结构的处理**。需要忽略单个对象和组合对象的区别，统一地处理它们。避免大量的条件判断语句。 |
| **核心关系** | **桥接关系**。通过组合（聚合）在抽象层持有实现层的接口。这是一个横向的连接。 | **组合关系**。组合对象包含对组件（可能是叶子，也可能是子组合）的引用。这是一个纵向的包含。 |
| **结构特点** | 两个平行的继承（或接口）层次：<br>1.  **抽象化角色** 的层次。<br>2.  **实现化角色** 的层次。 | 一个统一的组件接口，下分两类：<br>1.  **叶子节点**：没有子节点。<br>2.  **复合节点**：包含子组件（叶子或复合节点）。 |
| **关键代码** | 抽象化角色中**包含一个实现化接口的引用**。 | 组合对象（复合节点）的内部有一个**集合**，用于存储子组件。组合对象的方法通常委托给所有子组件。 |
| **应用场景** | - 不同平台上的窗口系统（抽象：窗口类型；实现：平台API）<br>- 不同数据库和不同持久化方式（抽象：DAO；实现：JDBC驱动）<br>- 不同形状和不同颜色（抽象：形状；实现：颜色） | - 文件系统（文件是叶子，文件夹是组合）<br>- GUI界面（按钮是叶子，面板是组合）<br>- 公司组织架构（员工是叶子，部门是组合） |

### 总结与关键区别

| 特征 | 桥接模式 | 组合模式 |
| :--- | :--- | :--- |
| **关系性质** | **横向协作**。一个维度（抽象）使用另一个维度（实现）。 | **纵向包含**。整体包含部分，形成树形结构。 |
| **变化维度** | **处理两个（或多个）独立变化的维度**。 | **处理一个维度上的层次结构**。 |
| **核心目的** | **解耦**，防止继承泛滥，提高灵活性。 | **统一**，简化客户端代码，使其一致地处理简单和复杂元素。 |

简单记忆：
*   当你发现你的类有 **两个正交的、独立变化的维度** 时（比如“形状”和“颜色”），考虑**桥接模式**。
*   当你需要表示一个 **树形结构**，并希望忽略叶子对象和组合对象的区别时，考虑**组合模式**。

---
它们可以结合使用，例如，在组合模式的 `FileSystemComponent` 接口的实现中，其绘制功能可以通过桥接模式来解耦不同的渲染引擎。

### 装饰器模式

### 外观模式
在代码中，Facade是以一个类的实例的形式存在的。它不是抽象的概念，而是一个你可以创建和调用的具体对象。

Facade的核心目的：它自己有一个简单明了的方法（接口），让外部很容易调用。

需要被简化的对象：它通常部署一个小模块，而可能是一个：

* 复杂的类库
* 庞大的框架
* 一系列相互关联、相互依赖的类组成的子系统

### 享元模式
现实世界：

例子：茶摊卖新鲜茶时，不会没来一个顾客就重新煮一次，而是一次性多煮一些，保存起来给多个顾客分享。

目的：节省资源（如煤气、时间、茶叶等）

联系到设计模式：享元模式的核心就是 共享---通过共享相同的对象来减少资源消耗，提高效率。

在软件工程中，享元模式用于减少内存使用，通过共享尽可能多的相似对象来处理大量细粒度的对象。

关键概念：

1. 内在状态
* 可以共享的、不变的部分
* 在茶摊例子中：茶的味道、配方（所有顾客喝的茶都是一样的）
2. 外在状态
* 不可共享的、变化的部分
* 在茶摊例子中：哪个顾客喝、什么时候喝、用哪个杯子装

共享相同内容：多个顾客共享一壶茶

节省资源：避免重复创建相同的对象

分离变与不变：茶的配方不变（内在状态），顾客信息变化（外在状态）

这种模式在处理大量相似对象时（如图形编辑器中的字符、游戏中的树木等）特别有用，能显著降低内存占用。

享元模式的两个主要目标：

1. 最小化内存使用
* 减少程序中对象的数量
* 避免重复存储相同是数据
2. 最小化计算开销
* 避免重复执行相同的计算
* 复用已经创建的对象和计算结果

关键机制：共享

找出对象中相同的部分

让多个对象共享这些相同的部分

只保留不同的部分（外在状态）作为单独数据

实际例子：

例子1：文字处理器
````
// 共享的字符样式（内在状态）
class CharacterStyle {
    private String font;
    private int size;
    private String color;
    
    public CharacterStyle(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }
    // 这个对象可以被多个字符共享
}

// 字符本身（包含位置信息）
class Character {
    private char value;
    private int position;
    private CharacterStyle style; // 共享的样式对象
    
    public Character(char value, int position, CharacterStyle style) {
        this.value = value;
        this.position = position;
        this.style = style; // 引用共享的样式
    }
}
````
如果没有享元模式：

文档中每个字符都创建完整的样式对象

内存使用：1000个字符 × 每个样式对象 = 1000个对象

使用享元模式后：

只有几种不同的样式对象被共享

内存使用：1000个字符 + 5种样式 = 1005个对象（大大减少）

例子2：游戏开发

````
// 共享的树木类型（内在状态）
class TreeType {
    private String name;
    private String texture;
    private String color;
    
    public TreeType(String name, String texture, String color) {
        this.name = name;
        this.texture = texture;
        this.color = color;
    }
    
    public void draw(int x, int y) {  // x,y是外在状态
        System.out.println("在位置(" + x + "," + y + ")绘制" + name);
    }
}

// 树木工厂 - 确保共享
class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();
    
    public static TreeType getTreeType(String name, String texture, String color) {
        String key = name + texture + color;
        if (!treeTypes.containsKey(key)) {
            treeTypes.put(key, new TreeType(name, texture, color));
        }
        return treeTypes.get(key);
    }
}
````
问题：当需要创建大量相似对象时，直接创建会导致：

内存占用过高

创建和销毁开销大

解决方案：享元模式

共享不变的部分（内在状态）

分离变化的部分（外在状态）

通过工厂管理共享

### 代理模式
场景：用门禁卡开门

* 基本功能：门的本质功能就是"打开"

* 额外功能：但现代门禁系统增加了：

    * 访问控制（access card）

    * 安全绕过按钮（bypass button）

* 代理的作用：在"开门"这个基本功能之上，添加了额外的功能层
````
// 1. 首先定义门的核心接口
interface Door {
    void open();
    void close();
}

// 2. 实现基本的门功能
class LabDoor implements Door {
    public void open() {
        System.out.println("打开实验室的门");
    }
    
    public void close() {
        System.out.println("关闭实验室的门");
    }
}

// 3. 代理类 - 在基本功能上添加安全控制
class SecuredDoor {
    private Door door;
    
    public SecuredDoor(Door door) {
        this.door = door;
    }
    
    public void open(String password) {
        if (authenticate(password)) {
            door.open();  // 调用原始功能
        } else {
            System.out.println("访问被拒绝！密码错误");
        }
    }
    
    public void openWithCard(String cardNumber) {
        if (validateCard(cardNumber)) {
            door.open();  // 调用原始功能
        } else {
            System.out.println("门禁卡无效！");
        }
    }
    
    public void openWithButton() {
        System.out.println("使用安全绕过按钮开门");
        door.open();  // 调用原始功能
    }
    
    private boolean authenticate(String password) {
        return "secret".equals(password);
    }
    
    private boolean validateCard(String cardNumber) {
        return cardNumber.startsWith("ACME-");
    }
    
    public void close() {
        door.close();
    }
}

// 4. 使用示例
public class ProxyExample {
    public static void main(String[] args) {
        // 创建带安全代理的门
        SecuredDoor securedDoor = new SecuredDoor(new LabDoor());
        
        // 尝试不同的开门方式
        securedDoor.open("wrong");        // 访问被拒绝！密码错误
        securedDoor.open("secret");       // 打开实验室的门
        
        securedDoor.openWithCard("INVALID"); // 门禁卡无效！
        securedDoor.openWithCard("ACME-123"); // 打开实验室的门
        
        securedDoor.openWithButton();     // 使用安全绕过按钮开门
                                          // 打开实验室的门
    }
}
````
代理模式的核心思想
1. 不改变原有功能

    * 门的核心功能 open() 保持不变

    * 只是在原有功能基础上添加新的控制层

2. 添加额外功能

    代理可以添加：

    * 访问控制（验证权限）

    * 日志记录（记录谁什么时候开门）

    * 缓存（缓存验证结果）

    * 延迟加载（需要时才初始化复杂对象）

3. 透明性

   对于使用门的代码来说：

    * 它仍然是在"开门"

    * 但背后多了安全检查的逻辑

核心观点：

在核心功能之上添加额外的控制层

详细解析：

1. 核心功能 vs 附加功能
   核心功能：门的基本作用就是"打开"

附加功能：访问控制、安全验证、绕过机制等

关系：附加功能建立在核心功能之上，但不改变核心功能本身

2. 代理模式的作用
   就像现实中的门禁系统：

原始对象：普通的门（只有开门功能）

代理对象：门禁系统（在开门前先进行验证）

3. 关键特性
   透明性：用户感觉还是在"开门"，不知道背后有复杂的验证过程

增强性：在不修改原始门的情况下，增加了安全控制

灵活性：提供多种开门方式（门禁卡、按钮绕过等）

代理模式价值：

单一职责：门只负责"开/关"，安全验证由代理处理

开闭原则：可以轻松添加新的验证方式，而不修改原始门类

代码复用：同一个安全代理可以用于不同类型的门[SecuredDoor的实例变量private Door door]

现实世界中的其他代理例子
1. 网络代理：在访问网站时添加缓存、过滤
2. 虚拟代理：图片加载时先显示缩略图
3. 保护代理：控制对敏感对象的访问权限
4. 智能引用：统计对象使用次数，自动清理
5. 银行卡：代理了你访问银行金库的权限
6. 网页缓存：代理了原始服务器的内容访问
7. 防火墙：代理了网络连接的访问控制

## 行为型模式
核心关注点

* 关注对象之间的职责分配

* 解决"哪个对象应该负责什么行为"的问题

与结构型模式的区别

* 结构型模式：关注对象的组成和结构（静态关系）

* 行为型模式：关注对象间的通信和协作（动态交互）

核心问题

* 如何在一个软件组件中执行行为？

* 关注行为的执行方式、时机和协作

行为型模式的特点

* 对象间的协作：定义对象如何相互通信

* 职责分配：明确每个对象的责任范围

* 算法封装：将复杂算法封装在对象中

* 通信模式：标准化对象间的交互方式

具体模式示例
1. 观察者模式（Observer）
````
   // 定义对象间的一对多依赖关系
   interface Subject {
        void attach(Observer observer);
        void notifyObservers();
   }

    interface Observer {
        void update(String message);
    }

    // 当一个对象状态改变时，所有依赖它的对象都得到通知
````
2. 策略模式（Strategy）
````
   // 定义算法族，分别封装起来，使它们可以互相替换
   interface PaymentStrategy {
        void pay(int amount);
   }

    class CreditCardPayment implements PaymentStrategy {
        public void pay(int amount) {
            System.out.println("信用卡支付: " + amount);
        }
    }
    
    class PayPalPayment implements PaymentStrategy {
        public void pay(int amount) {
            System.out.println("PayPal支付: " + amount);
        }
    }
````
3. 命令模式（Command）
````
   // 将请求封装为对象，以便使用不同的请求、队列或日志来参数化其他对象
   interface Command {
        void execute();
   }

    class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }
    
        public void execute() {
            light.turnOn();  // 职责分配：命令对象负责执行具体操作
        }
    }
````
4. 责任链模式（Chain of Responsibility）
````
   // 为请求创建一系列接收者对象链
   abstract class Handler {
       protected Handler next;

       public void setNext(Handler next) {
       this.next = next;
       }

       public abstract void handleRequest(Request request);
   }

   // 每个处理器决定是否处理请求或传递给下一个
````
行为型模式 vs 结构型模式
好的，我将把图片中的内容转化为 Markdown 表格。

| 方面 | 结构型模式 | 行为型模式 |
| :--- | :--- | :--- |
| **关注点** | 对象组合和结构 | 对象交互和职责分配 |
| **关系** | 静态的"has-a"关系 | 动态的"communicates-with"关系 |
| **时间维度** | 编译时确定的结构 | 运行时确定的交互 |
| **例子** | 适配器、装饰器、外观 | 观察者、策略、命令 |

核心要点解析
1. "identify common communication patterns between objects"
   （识别对象间常见的通信模式）

行为型模式不是凭空创造的，而是从大量实际软件设计中总结出来的重复出现的通信解决方案

比如：一个对象状态改变需要通知其他多个对象（观察者模式）

2. "realize these patterns"
   （实现这些模式）

将这些通用的通信方案具体化为可重用的设计模板

提供标准的代码结构和实现方式

3. "increase flexibility in carrying out this communication"
   （提高进行这种通信的灵活性）

这是行为型模式的核心价值

让对象间的通信更加灵活、可维护、可扩展

具体理解
什么是"通信模式"？
指的是对象之间相互传递消息、调用方法、协作完成任务的标准化方式。

为什么需要识别和标准化？
java
// 没有使用设计模式 - 紧耦合的通信
class User {
private EmailService emailService;
private SMSService smsService;
private NotificationService notificationService;

    public void register() {
        // 直接调用多个服务 - 通信方式僵硬
        emailService.sendWelcomeEmail();
        smsService.sendVerificationSMS();
        notificationService.addToQueue();
    }
}

// 使用观察者模式 - 灵活的通信
class User {
private List<Observer> observers = new ArrayList<>();

    public void register() {
        // 统一的通信接口 - 灵活扩展
        notifyObservers("user_registered");
    }
    
    public void addObserver(Observer observer) {
        observers.add(observer); // 可动态添加新的通信对象
    }
}
行为型模式如何提高灵活性？
1. 解耦通信对象
   java
   // 命令模式：将请求发送者与接收者解耦
   interface Command {
   void execute();
   }

// 发送者不需要知道具体的接收者
class Invoker {
private Command command;
public void setCommand(Command command) {
this.command = command; // 可以灵活切换不同的命令
}
public void executeCommand() {
command.execute(); // 统一的通信接口
}
}
2. 动态改变行为
   java
   // 策略模式：运行时切换算法
   class PaymentProcessor {
   private PaymentStrategy strategy;

   public void setStrategy(PaymentStrategy strategy) {
   this.strategy = strategy; // 动态改变支付策略
   }

   public void processPayment(int amount) {
   strategy.pay(amount); // 统一的通信方式
   }
   }
3. 简化复杂通信
   java
   // 中介者模式：将多对多通信简化为一对多
   class ChatRoom { // 中介者
   public void sendMessage(User user, String message) {
   // 集中处理所有用户间的通信
   System.out.println(user.getName() + ": " + message);
   }
   }

// 用户之间不直接通信，都通过中介者
总结
这段话精确定义了行为型设计模式的：

起源：从实践中总结的通用通信方案

本质：标准化的对象交互模板

价值：提高通信的灵活性，让系统更容易适应变化

关键收获：行为型模式让我们的代码不是"硬编码"的对象通信，而是提供了一套可配置、可扩展、可维护的交互框架，这正是软件设计追求的核心目标之一。

### 责任链模式
核心概念

场景描述：

* 三个支付账户：A($100), B($300), C($1000)

* 支付优先级：A → B → C

* 购买金额：$210

* 支付过程：按顺序检查每个账户是否能支付

支付过程演示

第一步：检查账户A
````
// A账户有$100，需要$210
if (100 >= 210) {  // false
// 支付失败，转到下一个账户
}
````
第二步：检查账户B
````
java
// B账户有$300，需要$210
if (300 >= 210) {  // true
// 支付成功！从B账户扣除$210
// 责任链终止，不再检查C账户
}
````
结果：
使用账户B完成支付

账户A：跳过（余额不足）

账户C：未检查（链已终止）

核心概念分解

1. （构建对象链）

* 将多个处理对象连接成一条"链"

* 每个对象都知道它的下一个对象是谁

````
// 对象A → 对象B → 对象C
handlerA.setNext(handlerB);
handlerB.setNext(handlerC);
````
2. 请求从一端进入
* 请求只从链的第一个对象开始

* 客户端不需要知道链的具体结构
````
// 请求只发给链的开头
handlerA.handleRequest(request);
````
3. 在对象间持续传递
* 如果当前对象不能处理，就传给下一个

* 请求在链上"旅行
````
public void handleRequest(Request request) {
    if (canHandle(request)) {
        // 处理请求
    } else if (next != null) {
        // 传给下一个对象
        next.handleRequest(request);
    }
}
````
4. 直到找到合适的处理
* 链中第一个能处理该请求的对象会"拦截"它

* 处理完成后，传递停止

直观比喻

就像公司审批流程：

员工申请 → 项目经理 → 部门总监 → CEO

* 请求：报销申请

* 链：员工 → 经理 → 总监 → CEO

* 过程：申请从员工开始，逐级向上传递

* 结果：在某个级别获得批准（找到合适的处理器）
````
// 抽象处理器
abstract class Handler {
    protected Handler next;
    
    public void setNext(Handler next) {
        this.next = next;
    }
    
    public void handle(Request request) {
        if (canHandle(request)) {
            process(request);      // 处理请求
        } else if (next != null) {
            next.handle(request);  // 传递给下一个
        } else {
            System.out.println("没有人能处理这个请求");
        }
    }
    
    protected abstract boolean canHandle(Request request);
    protected abstract void process(Request request);
}

// 具体处理器
class ConcreteHandlerA extends Handler {
    protected boolean canHandle(Request request) {
        return request.getType().equals("A");
    }
    
    protected void process(Request request) {
        System.out.println("HandlerA 处理了请求");
    }
}

class ConcreteHandlerB extends Handler {
    protected boolean canHandle(Request request) {
        return request.getType().equals("B");
    }
    
    protected void process(Request request) {
        System.out.println("HandlerB 处理了请求");
    }
}

// 使用
public class Main {
    public static void main(String[] args) {
        // 构建链：A → B
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        handlerA.setNext(handlerB);
        
        // 发送请求
        Request request1 = new Request("B");
        handlerA.handle(request1); 
        // 输出：HandlerB 处理了请求（A不能处理，传给B，B处理）
        
        Request request2 = new Request("A");
        handlerA.handle(request2);
        // 输出：HandlerA 处理了请求（A直接处理）
    }
}
````
关键优势
* 解耦：发送者不知道最终由谁处理



* 灵活：可以动态调整链的顺序

* 可扩展：容易添加新的处理器

* 单一职责：每个处理器只关心自己能处理的任务

总结：
这句话描述的责任链模式就像一条"处理流水线"——请求从入口进入，在处理器链上流动，直到找到能处理它的那个处理器为止。这种设计让系统更加灵活和可维护。

### 命令模式
命令模式包含四个关键角色，用餐厅例子来解释：

1.Client(客户) - 您
* 发出命令的发起者
* 知道需要什么，但不直接执行

2.Invoker(调用者) - 服务员/遥控器
* 接收命令并转发
* 不关心命令的具体内容，只是传递

3.Command（命令） - 点餐内容/开机指令
* 封装了具体的操作请求
* 包含所有执行所需的信息

4.Receiver（接收者） - 厨师/电视机
* 真正执行命令的对象
* 拥有执行命令所需的知识和能力

命令模式的价值

1.  解耦
* 客户不需要知道具体的执行细节

    客户指客户端，第一个例子中的RestaurantClient，第二个例子中的TVClient

* 调用者不需要知道命令的具体内容

    调用者指：第一个例子中的Waiter，第二个例子中的RemoteControl

* 接收者不需要知道谁发起的请求

    接收者指：第一个例子中的Chef，第二个例子中的Television

2. 支持撤销/重做
````
interface Command {
    void execute();
    void undo(); // 可以添加撤销功能
}
````
3. 支持命令队列和日志
````
// 可以保存命令历史
class CommandManager {
    private List<Command> history = new ArrayList<>();
    
    public void executeCommand(Command cmd) {
        cmd.execute();
        history.add(cmd); // 记录命令历史
    }
}
````
4. 支持宏命令
````
// 组合多个命令
class MacroCommand implements Command {
    private List<Command> commands = new ArrayList<>();
    
    public void addCommand(Command cmd) {
        commands.add(cmd);
    }
    
    public void execute() {
        for (Command cmd : commands) {
            cmd.execute(); // 依次执行多个命令
        }
    }
}
````






