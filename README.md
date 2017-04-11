# Virtual-File-System
REQ1 A virtual disk must be stored in a single file in the working directory in the host file system.

REQ2 The VFS core must support the creation of a new disk with the specified maximum size at the specified location in the host file system.

REQ3 The VFS core must support several virtual disks in the host file system.

REQ4 The VFS core must support disposing of a virtual disk.

REQ5 The VFS core must support creating/deleting/renaming directories and files.

REQ6 The VFS core must support navigation: listing of files and folders, and going to a location expressed by a concrete path.

REQ7 The VFS core must support moving/copying directories and files, including hierarchy.

REQ8 The VFS core must support importing files and directories from the host file system.

REQ9 The VFS core must support exporting files and directories to the host file system.

REQ10 The VFS core must support querying of free/occupied space in the virtual disk.

REQ11 The VFS core must support file/folder search based on user-given keywords. The search should support the following options:

  case sensitive or insensitive search;

  • matching all keywords or matching any keyword;

  • starting search from a specified folder;

  • matching only files/subfolders or matching both files and subfolders;
  
REQ12 The client should support all the operations from part I (VFS Core).

REQ13 The client should, when connected with the server, allow the user to create a new account or to log in to an existing account.

REQ14 The client should offer to switch to an offline mode, and be able to operate without a connection to the server.

REQ15 The client should support linking an existing virtual disk to an active account.

REQ16 The server should store all the created unique accounts (see REQ13). For each account, the account name and the password should be saved.

REQ17 The server should track changes to linked virtual disks of existing accounts and synchronize, upon user request, the changes across machines.
