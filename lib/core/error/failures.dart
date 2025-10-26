// lib/core/error/failures.dart
import 'package:equatable/equatable.dart';

/// Base class for Failures returned from the Domain layer.
/// Keeps things testable and explicit instead of throwing exceptions.
abstract class Failure extends Equatable {
  final List<Object?> propsList;
  const Failure([this.propsList = const <Object?>[]]);

  @override
  List<Object?> get props => propsList;
}

/// Specific failures you can add to/extend as needed.
class ServerFailure extends Failure {
  const ServerFailure([super.props]);
}

class CacheFailure extends Failure {
  const CacheFailure([super.props]);
}

class NetworkFailure extends Failure {
  const NetworkFailure([super.props]);
}
