Ext.define('SdnMgr.store.CustomerInstance', {
    extend: 'Ext.data.Store',
    alias: 'store.customerinstance',

    model: 'SdnMgr.model.CustomerInstance',
    remoteFilter: true,

    proxy: {
        type: 'memory',
        reader: 'json'
    }
});
