Ext.define('SdnMgr.model.CustomerInstance', {
    extend: 'SdnMgr.model.Base',

    fields: [
        'id',
        'type',
        'name',
        'url',
        'release',
        {name: 'fixpack', type: 'auto'}
    ]
});
