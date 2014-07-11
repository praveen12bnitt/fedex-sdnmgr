Ext.define('SdnMgr.model.AppFixPack', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    fields: [{
            name: 'appName'
        }, {
            name: 'fixPackName'
        }, {
        	name: 'applied'
        }, {
            name: 'publishDate'
        }, {
        	name: 'product'
        }, {
        	name: 'appliedApps'
        }, {
        	name: 'pendingApps'
        }, {
        	name: 'desc'
        }
    ]
});