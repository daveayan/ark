ark
===
[![Build Status](https://travis-ci.org/daveayan/ark.png?branch=master)](https://travis-ci.org/daveayan/ark)

#### What is Ark?
An open source framework to allow creation of objects, set values on fields and get values from fields.

#### Whats the purpose?
Ark is meant to be used only for unit testing. It may not have good performance and security that is demanded of production code.

#### usage

From your java code one of the following methods can be used

###### To instantiate an object with any constructor (private, protected, public, default)

`import static com.daveayan.ark.Ark.*`

`instantiate(Class< ? > clazz)`

`instantiate(String fully_qualified_class_name)`

Example: To instantiate an object of type [Person](https://github.com/daveayan/ark/blob/master/src/test/java/com/daveayan/ark/sample/domain/Person.java):

`instantiate(Person.class)`

OR

`instantiate("com.daveayan.ark.sample.domain.Person")`

###### To get the value of any field (private, protected, public, default) on the object.

`import static com.daveayan.ark.Ark.*`

`on(your_object).get_value_on(your_field_name)`

Example: To get a field an object of type [Person](https://github.com/daveayan/ark/blob/master/src/test/java/com/daveayan/ark/sample/domain/Person.java):

`Person person = new Person()`

`String name = (String) on(person).get_value_on("name")`

###### To set the value of any field (private, protected, public, default) on the object.

`import static com.daveayan.ark.Ark.*`

`on(your_object).set(your_field_name).value(value_to_set)`

Example: To get a field an object of type [Person](https://github.com/daveayan/ark/blob/master/src/test/java/com/daveayan/ark/sample/domain/Person.java):

`Person person = new Person()`

`on(person).set("name").value("QWERTY")`

###### To instantiate a complex object using a map.
To create a fully loaded isntance of the Person object, the following can be used:
(Shown in Groovy)

		  import static com.daveayan.ark.Ark.*
		  
		  def actual_object = construct_from_map(
			[	'class_name': 'com.daveayan.ark.sample.domain.Person',
				'name': 'AAA BBB',
				'addresses': [
						'collection_type': 'java.util.HashMap',
						'Home': [
							'class_name': 'com.daveayan.ark.sample.domain.Address',
							'address': '456 main st',
							'city': 'Dublin',
							'state': 'OH',
							'zip': '67890'
							],
						'Office': new Address('123 High St', 'Columbus', 'OH', '12345')
					],
				'phones': [
						[	'collection_type': 'java.util.ArrayList'],
						[	'class_name': 'com.daveayan.ark.sample.domain.PhoneNumber',
							'areaCode': '987',
							'number': '654321'],
						new PhoneNumber('876', '543210')
					],
				'accounts': [
						[	'collection_type': 'java.util.ArrayList'],
						[	'class_name': 'com.daveayan.ark.sample.domain.Account',
							'accountNumber': 736252,
							'balance': 122.333f,
							'lastUpdate': new Date()],
						new Account(3323, 7474.535)
					],
				'drives': [
						[	'collection_type': 'java.util.ArrayList'],
						[	'class_name': 'com.daveayan.ark.sample.domain.Car'],
						[	'class_name': 'com.daveayan.ark.sample.domain.Car',
							'numberOfWheels': 8],
						 	new Scooter()
					]])

