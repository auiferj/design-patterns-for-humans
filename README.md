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

“方法”-它是一个方法，不是类。

如果在多个地方要创建一个对象，这个对象属于同一个类，且创建时有比较复杂的逻辑而非简单的赋值，就用简单工厂。

如果在多个地方要创建一个对象，这个对象属于不同的类，那么就用工厂方法。每新增一种产品，就新增一种工厂方法的实现。

### 抽象工厂
