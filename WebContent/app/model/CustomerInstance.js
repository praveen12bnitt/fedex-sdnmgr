Ext.define('SdnMgr.model.CustomerInstance', {
    extend: 'SdnMgr.model.Base',

    fields: [
        'id',
        'type',
        'name',
        'url',
        'release',
        'applied',
        'pending',
        'hostname',
        {name: 'fixpack', type: 'auto'}
    ]
});
