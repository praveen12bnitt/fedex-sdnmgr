Ext.define('SdnMgr.store.AppFixPacks', {
    extend: 'Ext.data.Store',

    requires: [
        'SdnMgr.model.AppFixPack',
        'Ext.data.proxy.Rest',
        'Ext.data.reader.Json'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'SdnMgr.model.AppFixPack',
            storeId: 'AppFixPacks',
            proxy: {
                type: 'rest',
                url: 'api/sdn/listAppFixPacksForCust',
                reader: {
                    type: 'json',
                    rootProperty: ''
                }
            }
        }, cfg)]);
    }
});