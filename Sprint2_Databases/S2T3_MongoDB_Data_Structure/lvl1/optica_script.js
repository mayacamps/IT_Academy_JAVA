
db.createCollection( 'supplier', {validator: {$jsonSchema: {bsonType: 'object',title:'supplier',required: [         'name',          'address',          'phone',          'fax',          'nif',          'brands'],properties: {name: {bsonType: 'string'},address: {bsonType: 'object',
title:'object',required: [         'street',          'number',          'floor',          'door',          'city',          'zipcode',          'country'],properties: {street: {bsonType: 'string'},number: {bsonType: 'int'},floor: {bsonType: 'string'},door: {bsonType: 'int'},city: {bsonType: 'string'},zipcode: {bsonType: 'int'},country: {bsonType: 'string'}}},phone: {bsonType: 'string'},fax: {bsonType: 'int'},nif: {bsonType: 'string'},brands: {bsonType: 'array',items: {
title:'object',required: [         'id',          'name'],properties: {id: {bsonType: 'objectId'},name: {bsonType: 'string'}}}}}         }      },
autoIndexId:true
});  
 db.supplier.createIndex(
{
"nif": 1
},
 {
name: "supplier_ix_1",
unique: true
}
)


db.createCollection( 'customer', {validator: {$jsonSchema: {bsonType: 'object',title:'customer',required: [         'name',          'address',          'phone',          'email',          'registration_date',          'id_recom_customer'],properties: {name: {bsonType: 'string'},address: {bsonType: 'object',
title:'object',required: [         'street',          'number',          'floor',          'door',          'city',          'zipcode',          'country'],properties: {street: {bsonType: 'string'},number: {bsonType: 'int'},floor: {bsonType: 'string'},door: {bsonType: 'int'},city: {bsonType: 'string'},zipcode: {bsonType: 'int'},country: {bsonType: 'string'}}},phone: {bsonType: 'int'},email: {bsonType: 'string'},registration_date: {bsonType: 'date'},orders: {bsonType: 'array',items: {
title:'object',required: [         'id_employee'],properties: {glasses: {bsonType: 'array',items: {
title:'object',required: [         'type_frame',          'color_frame',          'price',          'id_brand',          'color_crystal'],properties: {type_frame: {enum: ['floating', 'plastic_frame', 'metallic']},color_frame: {bsonType: 'string'},price: {bsonType: 'double'},id_brand: {bsonType: 'objectId'},color_crystal: {bsonType: 'array',items: {
title:'object',required: [         'left',          'right'],properties: {left: {bsonType: 'string'},right: {bsonType: 'string'}}}},prescription: {bsonType: 'array',items: {
title:'object',properties: {left: {bsonType: 'double'},right: {bsonType: 'double'}}}}}}},id_employee: {bsonType: 'objectId'}}}},id_recom_customer: {bsonType: 'objectId'}}         }      },
autoIndexId:true
});  
db.createCollection( 'employee', {validator: {$jsonSchema: {bsonType: 'object',title:'employee',required: [         'name',          'nif'],properties: {name: {bsonType: 'string'},nif: {bsonType: 'string'}}         }      },
autoIndexId:true
});  
 db.employee.createIndex(
{

},
 {
name: "employee_ix_1",
unique: true
}
)

