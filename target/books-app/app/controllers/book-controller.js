(function() {

    var BookController =  function() {
        
    	var vm = this;
        
        vm.isHidden = false;
        
        vm.books = [
        	{'firstName': 'Declan', 'secondName': 'Cordial','bookNumber': '1234'},
        	{'firstName': 'Niall','secondName': 'Mulready','bookNumber': '1235'},
        	{'firstName': 'Ian','secondName': 'Cunningham','bookNumber': '1236'},
        	{'firstName': 'Brendan','secondName': 'Greene','bookNumber': '1237'},
        	{'firstName': 'Nicholas','secondName': 'Tsang','bookNumber': '1238'},
        	{'firstName': 'Sean','secondName': 'McGee','bookNumber': '1239'},
        	{'firstName': 'Anthony','secondName': 'Shannon','bookNumber': '1240'},
        	{'firstName': 'Conor','secondName': 'Harney','bookNumber': '1241'},
        	{'firstName': 'Decland','secondName': 'Horlick','bookNumber': '1242'},
        	{'firstName': 'Joshua','secondName': 'Sherwood','bookNumber': '1243'},
        	{'firstName': 'Bau','secondName': 'Nguyen','bookNumber': '1243'},
        	{'firstName': 'Kennedy','secondName': 'Bowers','bookNumber': '1243'},
        	{'firstName': 'Daleel','secondName': 'Ramjan','bookNumber': '1243'},
        	{'firstName': 'Ismael','secondName': 'Omar','bookNumber': '1243'}
        	];
        
        vm.hideTable = function()
        {
        	vm.isHidden = !vm.isHidden
        };
            
    };

    angular.module('bookApp').controller('bookController', [BookController]);
}());