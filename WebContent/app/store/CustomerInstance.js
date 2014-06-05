Ext.define('SdnMgr.store.CustomerInstance', {
    extend: 'Ext.data.Store',
    alias: 'store.customerinstance',

    model: 'SdnMgr.model.CustomerInstance',
    remoteFilter: true,

    proxy: {
        type: 'memory',
        reader: 'json',
        data: [
            { id: 1,  type: "application",  name:"WM-Server", hostname:'vrhas5001.us.manh.com', port: '32000', url: "/apps/builds/wm", release: "2013", applied: 8, pending: 2},
            { id: 2,  type: "mda",  name: "MDA-Server",  hostname:'vrhas5001.us.manh.com', port: '33000', url: "/apps/builds/mda", release: "2013", applied: 9, pending: 6},
            { id: 3,  type: "mip",  name: "MIP-Server",  hostname:'vrhas5001.us.manh.com', port: '34000', url: "/apps/builds/mip", release: "2013", applied: 1, pending: 0}
        ]
    }
});
