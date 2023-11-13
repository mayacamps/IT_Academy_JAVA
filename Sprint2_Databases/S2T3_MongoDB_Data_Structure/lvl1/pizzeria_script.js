
db.createCollection( 'client', {validator: {$jsonSchema: {bsonType: 'object',title:'client',required: [         'name',          'surname',          'address',          'zipcode',          'phone',          'locality_id',          'order'],properties: {name: {bsonType: 'string'},surname: {bsonType: 'string'},address: {bsonType: 'string'},zipcode: {bsonType: 'int'},phone: {bsonType: 'string'},locality_id: {bsonType: 'objectId'},order: {bsonType: 'array',items: {
title:'object',required: [         'date_time',          'type',          'total_price',          'products'],properties: {date_time: {bsonType: 'timestamp'},type: {enum: ['delivery', 'pick-up']},total_price: {bsonType: 'double'},products: {bsonType: 'array',items: {
title:'object',required: [         'quant_products',          'id_product'],properties: {quant_products: {bsonType: 'int'},id_product: {bsonType: 'objectId'}}}},delivery: {bsonType: 'object',
title:'object',required: [         'datetime',          'id_employee'],properties: {datetime: {bsonType: 'timestamp'},id_employee: {bsonType: 'objectId'}}}}}}}         }      },
autoIndexId:true
});  

db.createCollection( 'product', {validator: {$jsonSchema: {bsonType: 'object',title:'product',required: [         'name',          'description',          'price'],properties: {name: {bsonType: 'string'},description: {bsonType: 'string'},price: {bsonType: 'double'},image: {bsonType: 'binData'},pizza_category: {bsonType: 'object',
title:'object',required: [         'name'],properties: {name: {bsonType: 'string'}}}}         }      },
autoIndexId:true
});  

db.createCollection( 'store', {validator: {$jsonSchema: {bsonType: 'object',title:'store',required: [         'locality',          'province',          'employee'],properties: {locality: {bsonType: 'string'},province: {bsonType: 'string'},employee: {bsonType: 'array',items: {
title:'object',required: [         'name',          'surname',          'nif',          'phone',          'type'],properties: {name: {bsonType: 'string'},surname: {bsonType: 'string'},nif: {bsonType: 'string'},phone: {bsonType: 'string'},type: {enum: ['cook', 'delivery']}}}}}         }      },
autoIndexId:true
});  

db.createCollection( 'province', {validator: {$jsonSchema: {bsonType: 'object',title:'province',required: [         'name',          'localities'],properties: {name: {bsonType: 'string'},localities: {bsonType: 'array',items: {
title:'object',required: [         'name'],properties: {name: {bsonType: 'string'}}}}}         }      },
autoIndexId:true
});  