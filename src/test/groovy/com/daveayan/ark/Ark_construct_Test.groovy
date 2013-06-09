package com.daveayan.ark

import static com.daveayan.ark.Ark.*

import org.junit.Test

import com.daveayan.ark.sample.C
import com.daveayan.ark.sample.domain.Account
import com.daveayan.ark.sample.domain.Address
import com.daveayan.ark.sample.domain.Car
import com.daveayan.ark.sample.domain.Drivable
import com.daveayan.ark.sample.domain.PhoneNumber
import com.daveayan.ark.sample.domain.Scooter
import com.daveayan.mirage.ReflectionUtils

class Ark_construct_Test {
	@Test
	public void returns_null_when_map_is_null() {
		def actual_object = construct_from_map(null)
		assert null == actual_object
	}
	
	@Test
	public void construct_A_without_any_values() {
		def actual_object = construct_from_map(['class_name': 'com.daveayan.ark.sample.A'])
		assert null != actual_object
	}
	
	@Test
	public void construct_A_with_primitive_values_set() {
		def actual_object = construct_from_map(
			[	'class_name': 'com.daveayan.ark.sample.A', 
				'a_private_primitive_int': 401,
				'a_protected_primitive_int': 402,
				'a_public_primitive_int': 403,
				'a_default_primitive_int': 404,
				'a_private_object_int': 405,
				'a_protected_object_int': 406,
				'a_public_object_int': 407,
				'a_default_object_int': 408])
		assert null != actual_object
		assert 401 == ReflectionUtils.get_value_on_field(actual_object, 'a_private_primitive_int')
		assert 402 == ReflectionUtils.get_value_on_field(actual_object, 'a_protected_primitive_int')
		assert 403 == ReflectionUtils.get_value_on_field(actual_object, 'a_public_primitive_int')
		assert 404 == ReflectionUtils.get_value_on_field(actual_object, 'a_default_primitive_int')
		assert 405 == ReflectionUtils.get_value_on_field(actual_object, 'a_private_object_int')
		assert 406 == ReflectionUtils.get_value_on_field(actual_object, 'a_protected_object_int')
		assert 407 == ReflectionUtils.get_value_on_field(actual_object, 'a_public_object_int')
		assert 408 == ReflectionUtils.get_value_on_field(actual_object, 'a_default_object_int')
	}
	
	@Test
	public void construct_A_with_primitive_values_set_on_this_and_parent_object() {
		def actual_object = construct_from_map(
			[	'class_name': 'com.daveayan.ark.sample.B',
				'a_private_primitive_int': 401,
				'a_protected_primitive_int': 402,
				'a_public_primitive_int': 403,
				'a_default_primitive_int': 404,
				
				'a_private_object_int': 405,
				'a_protected_object_int': 406,
				'a_public_object_int': 407,
				'a_default_object_int': 408,
				
				'b_private_primitive_int': 409,
				'b_protected_primitive_int': 410,
				'b_public_primitive_int': 411,
				'b_default_primitive_int': 412,
				
				'b_private_object_int': 413,
				'b_protected_object_int': 414,
				'b_public_object_int': 415,
				'b_default_object_int': 416])
		assert null != actual_object
		assert 401 == ReflectionUtils.get_value_on_field(actual_object, 'a_private_primitive_int')
		assert 402 == ReflectionUtils.get_value_on_field(actual_object, 'a_protected_primitive_int')
		assert 403 == ReflectionUtils.get_value_on_field(actual_object, 'a_public_primitive_int')
		assert 404 == ReflectionUtils.get_value_on_field(actual_object, 'a_default_primitive_int')
		
		assert 405 == ReflectionUtils.get_value_on_field(actual_object, 'a_private_object_int')
		assert 406 == ReflectionUtils.get_value_on_field(actual_object, 'a_protected_object_int')
		assert 407 == ReflectionUtils.get_value_on_field(actual_object, 'a_public_object_int')
		assert 408 == ReflectionUtils.get_value_on_field(actual_object, 'a_default_object_int')
		
		assert 409 == ReflectionUtils.get_value_on_field(actual_object, 'b_private_primitive_int')
		assert 410 == ReflectionUtils.get_value_on_field(actual_object, 'b_protected_primitive_int')
		assert 411 == ReflectionUtils.get_value_on_field(actual_object, 'b_public_primitive_int')
		assert 412 == ReflectionUtils.get_value_on_field(actual_object, 'b_default_primitive_int')

		assert 413 == ReflectionUtils.get_value_on_field(actual_object, 'b_private_object_int')
		assert 414 == ReflectionUtils.get_value_on_field(actual_object, 'b_protected_object_int')
		assert 415 == ReflectionUtils.get_value_on_field(actual_object, 'b_public_object_int')
		assert 416 == ReflectionUtils.get_value_on_field(actual_object, 'b_default_object_int')
	}
	
	@Test
	public void construct_B_with_composite() {
		def actual_object = construct_from_map(
			[	'class_name': 'com.daveayan.ark.sample.B',
				'a_private_primitive_int': 401,
				'a_default_primitive_int': 404,
				'c_private': 
					[	'class_name': 'com.daveayan.ark.sample.C',
						'c_private_primitive_int': 501,
						'c_protected_primitive_int': 502],
				'a_protected_primitive_int': 402,
				'a_public_primitive_int': 403,
				])
		assert null != actual_object
		assert 401 == ReflectionUtils.get_value_on_field(actual_object, 'a_private_primitive_int')
		assert 402 == ReflectionUtils.get_value_on_field(actual_object, 'a_protected_primitive_int')
		assert 403 == ReflectionUtils.get_value_on_field(actual_object, 'a_public_primitive_int')
		assert 404 == ReflectionUtils.get_value_on_field(actual_object, 'a_default_primitive_int')
		
		C actual_c = ReflectionUtils.get_value_on_field(actual_object, 'c_private')
		assert null != actual_c
		assert 501 == ReflectionUtils.get_value_on_field(actual_c, 'c_private_primitive_int')
		assert 502 == ReflectionUtils.get_value_on_field(actual_c, 'c_protected_primitive_int')
	}
	
	@Test
	public void construct_Person_with_List_native_creation() {
		def actual_object = construct_from_map(
			[	'class_name': 'com.daveayan.ark.sample.domain.Person',
				'name': 'AAQQWW',
				'phones': [
					[	'collection_type': 'java.util.ArrayList'], 
						new PhoneNumber('123', '332233'), 
						new PhoneNumber('444', '221122')
				]])
		
		assert null != actual_object
		assert 'AAQQWW' == ReflectionUtils.get_value_on_field(actual_object, 'name')
		
		List<PhoneNumber> phones = ReflectionUtils.get_value_on_field(actual_object, 'phones')
		assert 2 == phones.size()
		assert '123' == phones[0].areaCode
		assert '332233' == phones[0].number
		assert '444' == phones[1].areaCode
		assert '221122' == phones[1].number
	}
	
	@Test
	public void construct_Person_with_List_map_creation() {
		def actual_object = construct_from_map(
			[	'class_name': 'com.daveayan.ark.sample.domain.Person',
				'name': 'AAQQWW',
				'phones': [
						['collection_type': 'java.util.ArrayList'],
						[	'class_name': 'com.daveayan.ark.sample.domain.PhoneNumber',
							'areaCode': '556',
							'number': '332233'],
						[	'class_name': 'com.daveayan.ark.sample.domain.PhoneNumber',
							'areaCode': '887',
							'number': '221122']
					]])
		
		assert null != actual_object
		assert 'AAQQWW' == ReflectionUtils.get_value_on_field(actual_object, 'name')
		
		List<PhoneNumber> phones = ReflectionUtils.get_value_on_field(actual_object, 'phones')
		assert 2 == phones.size()
		assert '556' == phones[0].areaCode
		assert '332233' == phones[0].number
		assert '(556)332233' == phones[0].toString()
		assert '887' == phones[1].areaCode
		assert '221122' == phones[1].number
		assert '(887)221122' == phones[1].toString()
	}
	
	@Test
	public void construct_Person_with_Hybrid_map_creation() {
		def actual_object = construct_from_map(
			[	'class_name': 'com.daveayan.ark.sample.domain.Person',
				'name': 'AAQQWW',
				'phones': [
						['collection_type': 'java.util.ArrayList'],
						[	'class_name': 'com.daveayan.ark.sample.domain.PhoneNumber',
							'areaCode': '556',
							'number': '332233'],
						new PhoneNumber('998', '221122')
					]])
		
		assert null != actual_object
		assert 'AAQQWW' == ReflectionUtils.get_value_on_field(actual_object, 'name')
		
		List<PhoneNumber> phones = ReflectionUtils.get_value_on_field(actual_object, 'phones')
		assert 2 == phones.size()
		assert '556' == phones[0].areaCode
		assert '332233' == phones[0].number
		assert '(556)332233' == phones[0].toString()
		assert '998' == phones[1].areaCode
		assert '221122' == phones[1].number
		assert '(998)221122' == phones[1].toString()
	}
	
	@Test
	public void construct_fully_loaded_Person_hybrid() {
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
		
		assert null != actual_object
		assert 'AAA BBB' == ReflectionUtils.get_value_on_field(actual_object, 'name')
		
		Map<String, Address> addresses = ReflectionUtils.get_value_on_field(actual_object, "addresses");
		assert null != addresses
		Address address = addresses['Home']
		assert 'Address : 456 main st, OH, Dublin, 67890' == address.toString()
		
		address = addresses['Office']
		assert 'Address : 123 High St, Columbus, OH, 12345' == address.toString()
		
		
		List<PhoneNumber> phones = ReflectionUtils.get_value_on_field(actual_object, 'phones')
		assert 2 == phones.size()
		assert '987' == phones[0].areaCode
		assert '654321' == phones[0].number
		assert '(987)654321' == phones[0].toString()
		
		assert '876' == phones[1].areaCode
		assert '543210' == phones[1].number
		assert '(876)543210' == phones[1].toString()
		
		List<Account> accounts = ReflectionUtils.get_value_on_field(actual_object, 'accounts')
		assert 2 == accounts.size()
		assert 736252 == accounts[0].accountNumber;
		assert 122.333f == accounts[0].balance;
		assert null != accounts[0].lastUpdate
		println accounts[0].lastUpdate
		
		assert 3323 == accounts[1].accountNumber;
		assert 7474.535f == accounts[1].balance;
		assert null != accounts[1].lastUpdate
		println accounts[1].lastUpdate
		
		List<Drivable> drives = ReflectionUtils.get_value_on_field(actual_object, 'drives')
		assert null != drives
		assert 3 == drives.size()
		
		assert drives[0] instanceof Car
		assert 0 == drives[0].numberOfWheels
		
		assert drives[1] instanceof Car
		assert 8 == drives[1].numberOfWheels
		
		assert drives[2] instanceof Scooter
		assert 2 == drives[2].numberOfWheels
	}
}
