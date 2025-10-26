// lib/core/error/exceptions.dart

/// Exceptions thrown by the Data layer. These are internal and
/// should be converted to Failure in the repository implementation.
class ServerException implements Exception {
  final String? message;
  ServerException([this.message]);

  @override
  String toString() => message ?? 'ServerException';
}

class CacheException implements Exception {
  final String? message;
  CacheException([this.message]);

  @override
  String toString() => message ?? 'CacheException';
}

class NetworkException implements Exception {
  final String? message;
  NetworkException([this.message]);

  @override
  String toString() => message ?? 'NetworkException';
}
