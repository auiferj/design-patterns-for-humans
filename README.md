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





