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

