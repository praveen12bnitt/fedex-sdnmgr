Ext.define('SdnMgr.store.FixPacks', {
    extend: 'Ext.data.Store',

    requires: [
        'SdnMgr.model.FixPack',
        'Ext.data.proxy.Rest',
        'Ext.data.reader.Json'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'SdnMgr.model.FixPack',
            storeId: 'DBColumns',
            proxy: {
                type: 'rest',
                url: '',
                reader: {
                    type: 'json',
                    root: 'data.items'
                }
            }
        }, cfg)]);
    }
});