## 使用
启动类中添加@EnableValidator
@Valid 对关联的对象进行校验

## 支持校验
@Size   检查被标注元素的长度
    
@NotNull检验被标注的值不为空

@Null   检验被标注的值为空

@Max    检查被标注的属性的值是否小于等于给定的值

@Min    检查被标注的属性的值是否大于等于给定的值

@AssertFalse 

@AssertTrue  检验boolean类型的值

## 自定义校验注解以及校验规则
继承HandlerAdapter类实现校验规则
