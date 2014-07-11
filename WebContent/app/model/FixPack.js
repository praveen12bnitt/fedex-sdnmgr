Ext.define('SdnMgr.model.FixPack', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
        {
            name: 'name',
            type: 'string'
        },
        {
            name: 'applied',
            type: 'boolean'
        },
        {
            name: 'publishDate'
        }
    ]
});