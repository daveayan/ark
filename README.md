ark
===
[![Build Status](https://travis-ci.org/daveayan/ark.png?branch=master)](https://travis-ci.org/daveayan/ark)

#### usage


From your java code one of the following methods can be used

###### To get the value of any field (private, protected, public, default) on the object.

`ArkUtils.get_value_on_field(Object target, String field_name)`


###### To set the value of any field (private, protected, public, default) on the object.

`ArkUtils.set_value_on_field(Object target, String field_name, Object value)`

###### To instantiate an object with any constructor (private, protected, public, default)

`ArkUtils.instantiate(Class< ? > clazz)`

